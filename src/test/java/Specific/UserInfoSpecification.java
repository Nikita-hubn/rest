package Specific;

import static io.restassured.RestAssured.given;

public class UserInfoSpecification {
    public static String userInfo(String baseURL, String authToken){
        return given()
                .auth().oauth2(authToken)
                .baseUri(baseURL)
                .queryParam("fields", "ringId,login,id,$type")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("login");

    }

}
