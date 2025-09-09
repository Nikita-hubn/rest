package Specific;
import POJO.CreateIsuePojo;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.AnyOf.anyOf;

public class TaskCreationSpecification {
    public static String correctTaskCreationWithTypeExtract(String baseUrl, String authToken, CreateIsuePojo createIsuePojo) {
        return RestAssured.given()
                .auth().oauth2(authToken)
                .baseUri(baseUrl)
                .contentType("application/json")
                .accept("application/json")
                .body(createIsuePojo)
                .when()
                .post("/issues")
                .then()
                .log().all()
                .statusCode(anyOf(equalTo(200), equalTo(201)))
                .body("id", Matchers.notNullValue())
                .body("$type", Matchers.containsString("Issue"))
                .extract().path("$type");
    }
    public static String correctTaskCreationWithIDExtract(String baseUrl, String authToken, CreateIsuePojo createIsuePojo) {
        return RestAssured.given()
                .auth().oauth2(authToken)
                .baseUri(baseUrl)
                .contentType("application/json")
                .accept("application/json")
                .body(createIsuePojo)
                .when()
                .post("/issues")
                .then()
                .log().all()
                .statusCode(anyOf(equalTo(200), equalTo(201)))
                .body("id", Matchers.notNullValue())
                .body("$type", Matchers.containsString("Issue"))
                .extract().path("id");
    }
}