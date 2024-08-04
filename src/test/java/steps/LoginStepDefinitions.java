package steps;

import io.cucumber.java.pt.Dado;
import io.restassured.response.Response;
import service.AuthenticationService;
import util.AuthenticationContext;

public class LoginStepDefinitions {
    private final AuthenticationService authService;
    private final AuthenticationContext context;

    public LoginStepDefinitions(AuthenticationContext context) {
        this.authService = new AuthenticationService(context);
        this.context = context;
    }

    @Dado("estar autenticado com usuário de email {string} e senha {string}")
    public void estar_autenticado_com_usuário_de_email_e_senha(String email, String password) {
        Response authResponse = authService.authenticate(email, password);
        String token = authResponse.jsonPath().getString("access_token");
        var test = "asd";
        context.setAuthToken(token);
    }
}
