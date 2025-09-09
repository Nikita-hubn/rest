package Specific;
import POJO.UpdatePojo;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class TaskUpdateSpecification {
    public static String updateTask(String baseUrl, String authToken , UpdatePojo updatePojo, String issueID) {
        return RestAssured.given()
                .auth().oauth2(authToken)
                .baseUri(baseUrl)
                .pathParam("issueID", issueID)
                .queryParam("summary", updatePojo)
                .contentType("application/json")
                .accept("application/json")
                .body(updatePojo)
                .when()
                .post("/issues/{issueID}/")
                .then()
                .log().all()
                .statusCode(200)
                .body("$type", Matchers.containsString("Issue"))
                .extract().path("$type");

    }
}
