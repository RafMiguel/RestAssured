package metods.ViaCEP;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViaCEPMetodos {

    String urlRota;
    Response response;


    public void acessarURL(String url){

        Response response = RestAssured.request(Method.GET, url);


    }

    public void getInfoCEP(String cep){
        urlRota = cep;
        Response response = RestAssured.request(Method.GET, cep + "/json");
        System.out.println(response.statusCode());
        response.getBody().asPrettyString();

    }

    public void enderecos() throws IOException {

        String pathJson = "src/test/resources/features/ViaCEP/json/Enderecos.json";
        byte[] fileJson = Files.readAllBytes(Paths.get(pathJson));
        RestAssured.given()
                .when().body(fileJson);

    }

}
