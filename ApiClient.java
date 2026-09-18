package api;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ApiClient {
    private final String baseUrl = System.getProperty("apiBaseUrl", "https://reqres.in/api");

    public Response getUsers() {
        return given().baseUri(baseUrl).when().get("/users?page=2");
    }

    public Response createUser() {
        String body = "{\"name\":\"mobile-user\",\"job\":\"qa\"}";
        return given().baseUri(baseUrl).contentType("application/json").body(body)
                .when().post("/users");
    }
}
