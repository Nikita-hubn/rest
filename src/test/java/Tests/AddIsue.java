package Tests;

import POJO.CreateIsuePojo;
import Specific.TaskCreationSpecification;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AddIsue extends BaseTest {


    @Test
    void createTaskWithRequiredOnlyConstructorTest() {
        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project);
        String expectedValue = "Issue";
        String taskID = TaskCreationSpecification.correctTaskCreationWithTypeExtract(baseUrl, authToken, task);
        assertEquals(taskID, expectedValue);

    }
}
