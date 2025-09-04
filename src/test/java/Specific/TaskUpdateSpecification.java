package Specific;
import POJO.UpdatePojo;

import static io.restassured.RestAssured.given;

public class TaskUpdateSpecification {
    public static void updateTask(String baseUrl, String authToken , UpdatePojo updatePojo, String issueID) {
        given()
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
                .statusCode(200);

    }
}
