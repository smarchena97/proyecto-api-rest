package co.edu.uniquindio.apirest.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniquindio.apirest.entities.PQRS;

public interface PQRSService {

	List<PQRS> getAllPqrs();
	
	Optional<PQRS> getPqrsById(Long id);
	
	PQRS createPqrs(PQRS pqrs);
	
	PQRS updatePqrs(Long id, PQRS pqrs);
	
	void deletePqrs(Long id);
}
