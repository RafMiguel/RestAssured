package steps.ViaCEP;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import metods.ViaCEP.ViaCEPMetodos;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

public class ViaCEPSteps {

    Response response;
    String url, rotaCep;


    ViaCEPMetodos viaCEPMetodos = new ViaCEPMetodos();

    @Dado("que eu entre na URL {string}")
    public void que_eu_entre_na_url(String args0) {
        url = args0;
    }

    @Quando("eu consultar o CEP {string}")
    public void eu_consultar_o_cep(String cep) {

        rotaCep = url + cep + "/json";
        response = RestAssured.given()
                .when().get(rotaCep);


    }

    @Entao("retornar o logradouro {string}")
    public void retornar_o_logradouro(String logradouroEsperado) {

        response.then()
                .body("logradouro", Matchers.is(logradouroEsperado))
                .statusCode(200);
        response.then().log().status();
    }

    @Entao("retornar o logradouro incorreto {string}")
    public void retornarOLogradouroIncorretoLogradouro(String logradouroIncorreto) {

        Assertions.assertEquals(logradouroIncorreto, response.jsonPath().get("logradouro"));

    }


    @Entao("validar todos os dados do endereco {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void validarTodosOsDadosDoEndereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi) {

        response.then()
                .body("cep", Matchers.is(cep))
                .body("logradouro", Matchers.is(logradouro))
                .body("complemento", Matchers.is(complemento))
                .body("bairro", Matchers.is(bairro))
                .body("localidade", Matchers.is(localidade))
                .body("uf", Matchers.is(uf))
                .body("ibge", Matchers.is(ibge))
                .body("gia", Matchers.is(gia))
                .body("ddd", Matchers.is(ddd))
                .body("siafi", Matchers.is(siafi))
                .statusCode(200)
                .log().body();

    }
}
