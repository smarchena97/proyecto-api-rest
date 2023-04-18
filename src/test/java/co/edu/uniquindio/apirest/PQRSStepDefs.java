package co.edu.uniquindio.apirest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.repositories.PQRSRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PQRSStepDefs {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private PQRSRepository pqrsRepository;

	private ResponseEntity<String> response;
	private List<PQRS> pqrsList;
	private PQRS pqrs;

	@Given("Una solicitud de PQRS")
	public void una_solicitud_de_pqrs() {
		pqrs = new PQRS();

		pqrs.setId(1L);
		pqrs.setFechaCreacion(LocalDate.of(2023, 4, 17));
		pqrs.setAsunto("Pregunta acerca de cita");
		pqrs.setDescripcion("¿Cómo puedo solicitar una cita?");
		pqrs.setEstado("enviado");
		pqrs.setTipo("Pregunta");

	}

	/*
	 * Prueba para el primer escenario: Crear una nueva PQRS
	 */
	@When("La solicitud es enviada a la API")
	public void la_solicitud_es_enviada_a_la_api() {
		response = restTemplate.postForEntity("/pqrs/", pqrs, String.class);
	}

	@Then("La respuesta HTTP es 200")
	public void la_respuesta_http_es_200() {
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@And("La PQRS es creada en la base de datos")
	public void la_pqrs_es_creada_en_la_base_de_datos() {
		pqrsList = pqrsRepository.findAll();
		assertThat(pqrsList).hasSize(1);

		assertThat(pqrsList.get(0).getId()).isEqualTo(1L);
		assertThat(pqrsList.get(0).getFechaCreacion()).isEqualTo(LocalDate.of(2023, 4, 17));
		assertThat(pqrsList.get(0).getAsunto()).isEqualTo("Pregunta acerca de cita");
		assertThat(pqrsList.get(0).getDescripcion()).isEqualTo("¿Cómo puedo solicitar una cita?");
		assertThat(pqrsList.get(0).getEstado()).isEqualTo("enviado");
		assertThat(pqrsList.get(0).getTipo()).isEqualTo("Pregunta");

	}

	/*
	 * prueba para el segundo escenario: Obtener todas las PQRS NOTA: Este given es
	 * el mismo para los siguientes 3 escenarios
	 */
	@Given("Al menos una PQRS en la base de datos")
	public void listarPqrs() {
		pqrs = new PQRS();

		pqrs.setId(1L);
		pqrs.setFechaCreacion(LocalDate.of(2023, 4, 17));
		pqrs.setAsunto("Pregunta acerca de cita");
		pqrs.setDescripcion("¿Cómo puedo solicitar una cita?");
		pqrs.setEstado("enviado");
		pqrs.setTipo("Pregunta");

		pqrsRepository.save(pqrs);
	}

	@When("La solicitud es enviada a la API para obtener todas las PQRS")
	public void la_solicitud_es_enviada_a_la_api_para_obtener_todas_las_pqrs() {
		response = restTemplate.getForEntity("/pqrs/", String.class);
	}

	@Then("Todas las PQRS son retornadas")
	public void todas_las_pqrs_son_retornadas() {
		pqrsList = pqrsRepository.findAll();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(new Gson().toJson(pqrsList));
	}

	/*
	 * Prueba para el tercer escenario: Actualizar una PQRS existente
	 */

	@When("La solicitud es enviada a la API para actualizar la PQRS")
	public void la_solicitud_es_enviada_a_la_api_para_actualizar_la_pqrs() {
		pqrs.setDescripcion("¿Cuál es el horario de atención?");
		response = restTemplate.exchange("/pqrs/{id}", HttpMethod.PUT, null, String.class, pqrs.getId());
	}

	@And("La PQRS es actualizada en la base de datos")
	public void la_pqrs_es_actualizada_en_la_base_de_datos() {
		pqrsList = pqrsRepository.findAll();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(pqrsList.get(0).getDescripcion()).isEqualTo("¿Cuál es el horario de atención?");
	}

	/*
	 * Prueba para el tercer escenario: Eliminar una PQRS existente
	 */
	@When("La solicitud es enviada a la API para eliminar la PQRS")
	public void la_solicitud_es_enviada_a_la_api_para_eliminar_la_pqrs() {
		response = restTemplate.exchange("/pqrs/{id}", HttpMethod.DELETE, null, String.class, pqrs.getId());
	}

	@And("La PQRS es eliminada de la base de datos")
	public void la_pqrs_es_eliminada_de_la_base_de_datos() {
		pqrsList = pqrsRepository.findAll();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(pqrsList).isEmpty();
	}
}
