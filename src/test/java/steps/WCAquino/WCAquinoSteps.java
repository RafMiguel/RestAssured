package steps.WCAquino;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class WCAquinoSteps {

    Response response;
    String url;

    @Dado("que eu entre na API {string}")
    public void que_eu_entre_na_api(String args0) {url = args0;}{

    }
    @Quando("eu pesquisar por um cliente na API {int}")
    public void eu_pesquisar_por_um_cliente_na_api(Integer id) {
      response =  RestAssured.given()
                .when()
                .get(url + id);



    }
    @Quando("eu verificar a existência do cliente na base de dados {int} {string} {int}")
    public void eu_verificar_a_existência_do_cliente_na_base_de_dados(Integer id, String name, Integer age) {

response.then()
        .body("id", Matchers.is(id))
        .body("name", Matchers.is(name))
        .body("age", Matchers.is(age))
        .log().body();



    }
    @Entao("o cliente está cadastrado")
    public void o_cliente_está_cadastrado() {
        response.then().statusCode(200);

    }
}
