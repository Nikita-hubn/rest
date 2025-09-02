package Specific;
import POJO.CreateIsuePojo;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;

public class TaskCreationSpecification {
    public static String correctTaskCreationWithIDExtract(String baseUrl, String authToken, CreateIsuePojo createIsuePojo) {
        return RestAssured.given()
                .auth().oauth2(authToken)
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(createIsuePojo)
                .when()
                .post("/issues")
                .then()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("$type", Matchers.containsString("Issue"))
                .extract().path("id");
    }
}