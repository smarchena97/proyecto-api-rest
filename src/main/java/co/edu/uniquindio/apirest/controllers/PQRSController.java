package co.edu.uniquindio.apirest.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.apirest.entities.Error;
import co.edu.uniquindio.apirest.entities.ErrorResponse;
import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.services.PQRSService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/pqrs")
public class PQRSController {

	@Autowired
	private PQRSService pqrsService;

	// Obtener todas las PQRS
	@GetMapping
	public List<PQRS> getPqrs() {
		return pqrsService.getAllPqrs();
	}

	// Obtener una PQRS por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getPqrsById(@PathVariable("id") Long id) {
		Optional<PQRS> pqrs = pqrsService.getPqrsById(id);
		if (pqrs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "PQRS no encontrada", null));
		}
		return ResponseEntity.ok().body(pqrs);
	}

	@PostMapping("")
	public ResponseEntity<?> createPQRS(@Valid @RequestBody PQRS pqrs, BindingResult result) {
		if (result.hasErrors()) {
			List<Error> errors = new ArrayList<Error>();
			for (FieldError error : result.getFieldErrors()) {

				errors.add(new Error(error.getField(), error.getDefaultMessage()));
			}
			ErrorResponse errorResponse = new ErrorResponse(errors);
			return ResponseEntity.badRequest().body(errorResponse);
		}
		pqrsService.createPqrs(pqrs);
		return ResponseEntity.ok(pqrs);
	}

	// Actualizar una PQRS existente
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePqrs(@PathVariable("id") Long id, @Valid @RequestBody PQRS pqrs,
			BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error de validación", errors));
		}
		Optional<PQRS> existingPqrs = pqrsService.getPqrsById(id);
		if (existingPqrs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "PQRS no encontrada", null));
		}
		pqrs.setId(id);
		return ResponseEntity.ok().body(pqrsService.updatePqrs(id, pqrs));
	}

	// Elimina una PQRS existente
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarPQRS(@PathVariable(value = "id") Long pqrsId) {
		Optional<PQRS> pqrs = pqrsService.getPqrsById(pqrsId);
		if (!pqrs.isPresent()) {
			Error error = new Error("La PQRS con id " + pqrsId + " no existe", null);
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

		pqrsService.deletePqrs(pqrsId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
