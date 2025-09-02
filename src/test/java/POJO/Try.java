package POJO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Try {
    public static void printProjectsInfo() {
        String token = "perm-UUEx.NDMtMA==.C30yR1x3Y5jXMY9pBd4GM2Csm9gBw2";

        String response = given()
                .baseUri("https://example.youtrack.cloud")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .queryParam("fields", "id,name,shortName")
                .when()
                .get("/api/admin/projects")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        List<Map<String, Object>> projects = jsonPath.getList("$");

        System.out.println("=== PROJECTS LIST ===");
        for (Map<String, Object> project : projects) {
            System.out.println("ID: " + project.get("id"));
            System.out.println("Name: " + project.get("name"));
            System.out.println("Short Name: " + project.get("shortName"));
            System.out.println("Type: " + project.get("$type"));
            System.out.println("-------------------");
        }
    }
}
