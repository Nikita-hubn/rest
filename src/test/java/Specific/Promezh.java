package Specific;

import POJO.Try;

import static io.restassured.RestAssured.given;

public class Promezh {
    public static Try userInfo(String baseURL, String authToken, String login){
        return given()
                .auth().oauth2(authToken)
                .baseUri(baseURL)
                .pathParam("login", login)
                .queryParam("fields", "id,login,ringId")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("/api/users/{login}")
                //.get("/userdetails/{user detail id}")
                //.get("/api/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("id");
                //.as(UserInfoPojo.class);
    }
}
