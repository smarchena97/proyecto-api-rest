package co.edu.uniquindio.apirest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.repositories.PQRSRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
	      pqrs.setFechaCreacion(LocalDate.of(2023,4,17));
	      pqrs.setAsunto("Pregunta acerca de cita");
	      pqrs.setDescripcion("¿Cómo puedo solicitar una cita?");
	      pqrs.setEstado("enviado");
	      pqrs.setTipo("Pregunta");
	      
	   }
		
		/*
		 *Prueba para la creacion de una PQRS 
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
}
