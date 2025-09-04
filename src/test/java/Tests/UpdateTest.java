package Tests;

import POJO.CreateIsuePojo;
import POJO.UpdatePojo;
import Specific.TaskCreationSpecification;
import Specific.TaskDeleteSpecification;
import Specific.TaskUpdateSpecification;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UpdateTest extends BaseTest {

    @Test
    void updateSummaryTest() throws IOException {

        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project, taskDescription);

        String taskID = TaskCreationSpecification.correctTaskCreationWithIDExtract(baseUrl, authToken, task);

        UpdatePojo updatePojo = new UpdatePojo("*_*");

        TaskUpdateSpecification.updateTask(baseUrl, authToken, updatePojo, taskID);

        TaskDeleteSpecification.deleteTask(baseUrl, authToken, taskID);
    }
}
