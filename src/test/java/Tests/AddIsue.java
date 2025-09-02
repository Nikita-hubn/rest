package Tests;

import POJO.CreateIsuePojo;
import POJO.Try;
import Specific.TaskCreationSpecification;
import org.junit.jupiter.api.Test;

public class AddIsue extends BaseTest {

/*@Test
    public void AddIsue() {
    Try first = new Try();
    first.printProjectsInfo();
    System.out.println("1");
}
 */
    @Test
    void createTaskWithRequiredOnlyConstructorTest() {
        CreateIsuePojo task = new CreateIsuePojo(taskSummary, project);

        String taskID = TaskCreationSpecification.correctTaskCreationWithIDExtract(baseUrl, authToken, task);

    }
}
