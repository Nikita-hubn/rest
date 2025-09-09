package Tests;

import POJO.CreateIsuePojo;
import POJO.UpdatePojo;
import Specific.TaskCreationSpecification;
import Specific.TaskDeleteSpecification;
import Specific.TaskUpdateSpecification;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateTest extends BaseTest {

    @Test
    void updateSummaryTest() throws IOException {

        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project, taskDescription);

        String taskID = TaskCreationSpecification.correctTaskCreationWithIDExtract(baseUrl, authToken, task);

        UpdatePojo updatePojo = new UpdatePojo("*_*");
        String expectedValue = "Issue";
        String check=TaskUpdateSpecification.updateTask(baseUrl, authToken, updatePojo, taskID);
        assertEquals(check, expectedValue);
        TaskDeleteSpecification.deleteTask(baseUrl, authToken, taskID);
    }
}
