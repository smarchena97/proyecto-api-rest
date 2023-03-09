package co.edu.uniquindio.apirest.controllers;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.entities.PQRSDTO;
import co.edu.uniquindio.apirest.repositories.PQRSRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pqrs")
public class PQRSController {

    @Autowired
    private PQRSRespository pqrsRespository;

    @GetMapping("/")
    public List<PQRSDTO> getAllPQRS(){
        return pqrsRespository.findAll();
    }
}
