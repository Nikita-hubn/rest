package Tests;

import POJO.ProjectPojo;
import UTILS.PrepUtils;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    static String baseUrl;
    static String authToken;
    static String projectID;
    static String taskSummary;
    static String taskDescription;
    static ProjectPojo project;

    @BeforeAll
    static void beforeAll() throws IOException {
        Properties prop = PrepUtils.loadProperties();

        baseUrl = prop.getProperty("baseUrl");
        authToken = prop.getProperty("authToken");
        projectID = prop.getProperty("projectID");
        taskSummary = prop.getProperty("taskSummary");
        taskDescription = prop.getProperty("taskDescription");
        project = new ProjectPojo(projectID);

    }
}
