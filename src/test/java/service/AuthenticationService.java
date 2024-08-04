package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.AuthenticationContext;

public class AuthenticationService {
    private static final String BASE_URI = "http://localhost:8080/api/v1/auth";

    private final AuthenticationContext authenticationContext;

    public AuthenticationService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public Response authenticate(String email, String password) {
        var response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .post(BASE_URI + "/authentication");

        authenticationContext.setAuthToken(response.jsonPath().getString("token"));

        return response;
    }
}
