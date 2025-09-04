package Tests;

import POJO.CreateIsuePojo;
import Specific.TaskCreationSpecification;
import org.junit.jupiter.api.Test;

public class AddIsue extends BaseTest {


    @Test
    void createTaskWithRequiredOnlyConstructorTest() {
        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project);

        String taskID = TaskCreationSpecification.correctTaskCreationWithIDExtract(baseUrl, authToken, task);

    }
}
