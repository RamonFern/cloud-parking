package br.com.rf.parking.estacionamento;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.com.rf.parking.estacionamento.dto.EstacionamentoCreateDTO;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstacionamentoApplicationTests {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }
	
	@Test
    void whenFindAllThenCheckResult() {
	        RestAssured.given()
	                .when()
	                .get("/estacionamento")
	                .then()
	                .statusCode(HttpStatus.OK.value());
	    }
	
	@Test
    void whenCreateThenCheckIsCreated() {
        var createDTO = new EstacionamentoCreateDTO();
        createDTO.setCor("AMARELO");
        createDTO.setPlaca("WRT-5555");
        createDTO.setModelo("BRASILIA");
        createDTO.setEstado("SP");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/estacionamento")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("placa", Matchers.equalTo("SDD-5358"))
                .body("cor", Matchers.equalTo("VERDE"));
    }

}
