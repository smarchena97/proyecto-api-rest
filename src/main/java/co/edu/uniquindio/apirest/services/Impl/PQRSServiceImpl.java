package co.edu.uniquindio.apirest.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.repositories.PQRSRepository;
import co.edu.uniquindio.apirest.services.PQRSService;

@Service
public class PQRSServiceImpl implements PQRSService{

	@Autowired
	PQRSRepository pqrsRepository;
	
	@Override
    public List<PQRS> getAllPqrs() {
        return pqrsRepository.findAll();
    }

    @Override
    public Optional<PQRS> getPqrsById(Long id) {
        return pqrsRepository.findById(id);
    }

    @Override
    public PQRS createPqrs(PQRS pqrs) {
        return pqrsRepository.save(pqrs);
    }

    @Override
    public PQRS updatePqrs(Long id, PQRS pqrs) {
        pqrs.setId(id);
        return pqrsRepository.save(pqrs);
    }

    @Override
    public void deletePqrs(Long id) {
        pqrsRepository.deleteById(id);
    }

}
