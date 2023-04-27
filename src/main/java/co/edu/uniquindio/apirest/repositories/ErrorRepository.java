package co.edu.uniquindio.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.apirest.entities.Error;

@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {

}
