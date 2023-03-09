package co.edu.uniquindio.apirest.repositories;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.entities.PQRSDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PQRSRespository extends JpaRepository<PQRSDTO, Long> {


}
