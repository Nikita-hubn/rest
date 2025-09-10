package Specific;

import POJO.UserInfoPojo;


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
                //.get("/api/users/{login}")
                //.get("/userdetails/{user detail id}")
                .get("/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("login");
                //.as(UserInfoPojo.class);
    }


   /*  public static UserInfoPojo userInfo(String baseURL, String authToken, String id){
        return given()
                .auth().oauth2(authToken)
                .baseUri(baseURL)
                .pathParam("user detail id", id)
                //.queryParam("fields", "id,login,ringId")
                .contentType("application/json")
                .accept("application/json")
                .when()
                //.get("/api/users/{login}")
                .get("users/user id/userdetails/{user detail id}")
                //.get("/api/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserInfoPojo.class);
        //.as(UserInfoPojo.class);
    }
    .
    */
}
