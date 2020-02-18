package br.com.ultracar.treinamento;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CepTest {
	
	@LocalServerPort
	private int porta;
	
	@Before
	public void init() {
		RestAssured.port = porta;
		RestAssured.baseURI = "http://localhost";
	}
	
	@Test
	public void testeBuscaDesconhecida() {
		Integer cep = 31570200;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testeBuscaBlank() {
		String cep = StringUtils.EMPTY;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testeCepInvalido() {
		String cep = "315702006";
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testeCepStringInvalida() {
		String cep = "chuck norris";
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testeBuscaValida() {
		String cep = "30190060";
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}

	@Test
	public void testeBuscaValidaApi() {
		String cep = "31570200";
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
}
