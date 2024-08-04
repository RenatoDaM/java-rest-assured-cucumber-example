package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.AuthenticationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDefinitions {
    private final AuthenticationContext authenticationContext;
    private Response response;

    public UserStepDefinitions(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    @Quando("enviar uma requisição PUT para atualizar os dados do usuário logado")
    public void enviar_uma_requisição_put_para_atualizar_os_dados_do_usuário_logado() {
        String updateUri = "http://localhost:8080/api/v1/users";
        var test = authenticationContext.getAuthToken();
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + authenticationContext.getAuthToken())
                .contentType("application/json")
                .body("{ \"firstname\": \"NovoNome\", \"lastname\": \"NovoSobrenome\" }")
                .put(updateUri);
    }

    @Entao("a resposta do servidor deve possuir o status code {int}")
    public void a_resposta_do_servidor_deve_possuir_o_status_code(Integer expectedStatusCode) {
        assertThat(expectedStatusCode.intValue(), equalTo(response.getStatusCode()));
    }
}
