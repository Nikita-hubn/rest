package Specific;

import POJO.UserInfoPojo;


import static io.restassured.RestAssured.given;

public class UserInfoSpecification {
    public static UserInfoPojo userInfo(String baseURL, String authToken){
        return given()
                .auth().oauth2(authToken)
                .baseUri(baseURL)
                .queryParam("fields", "id,login,ringId")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("/api/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(UserInfoPojo.class);
    }
}
