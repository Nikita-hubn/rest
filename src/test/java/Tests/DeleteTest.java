package Tests;

import POJO.CreateIsuePojo;
import Specific.TaskCreationSpecification;
import Specific.TaskDeleteSpecification;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DeleteTest extends BaseTest{
    @Test
    void deleteTaskTest() throws IOException {

        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project, taskDescription);

        String taskID = TaskCreationSpecification.correctTaskCreationWithIDExtract(baseUrl, authToken, task);

        TaskDeleteSpecification.deleteTask(baseUrl, authToken, taskID);
    }
}
