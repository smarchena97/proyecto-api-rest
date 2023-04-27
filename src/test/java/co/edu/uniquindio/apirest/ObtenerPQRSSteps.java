package co.edu.uniquindio.apirest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDateTime;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysema.commons.lang.Assert;

import co.edu.uniquindio.apirest.constants.EstadoEnum;
import co.edu.uniquindio.apirest.constants.TipoEnum;
import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.repositories.PQRSRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class ObtenerPQRSSteps {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PQRSRepository pqrsRepository;

	private int id;
	private MvcResult result;

	@Given("^hay una PQRS con id (\\d+) en la base de datos$")
	public void hayUnaPQRSConIdEnLaBaseDeDatos(int id) throws Exception {
		PQRS pqrs = new PQRS((long) id, "peticion de prueba", TipoEnum.PETICION, "prueba", "esta es una pqrs de prueba",
				EstadoEnum.ENVIADO, LocalDateTime.now(), null);
		pqrsRepository.save(pqrs);
	}

	@When("^se solicita obtener la PQRS con id (\\d+)$")
	public void seSolicitaObtenerLaPQRSConId(int id) throws Exception {
		this.id = id;
		result = mockMvc.perform(get("/pqrs/" + id)).andReturn();
	}

	@Then("^se debe responder con un código de estado (\\d+)$")
	public void seDebeResponderConUnCódigoDeEstado(int statusCode) throws Exception {
		assertEquals(statusCode, result.getResponse().getStatus());
	}

	@And("^la respuesta debe tener la información de la PQRS con id (\\d+)$")
	public void laRespuestaDebeTenerLaInformaciónDeLaPQRSConId(int id) throws Exception {
		String content = result.getResponse().getContentAsString();
		PQRS p = new ObjectMapper().readValue(content, PQRS.class);
		Assertions.assertEquals(id, p.getId());
	}
}