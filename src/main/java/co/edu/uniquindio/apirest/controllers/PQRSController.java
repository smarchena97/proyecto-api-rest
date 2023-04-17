package co.edu.uniquindio.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.apirest.entities.PQRS;
import co.edu.uniquindio.apirest.repositories.PQRSRepository;

@RestController
@RequestMapping("api/v1/pqrs")
public class PQRSController {

    @Autowired
    private PQRSRepository pqrsRepository;

    @GetMapping("/")
    public List<PQRS> getAllPQRS(){
        return pqrsRepository.findAll();
    }
    
    @PostMapping("/")
    public PQRS create(@RequestBody PQRS pqrs) {
       return pqrsRepository.save(pqrs);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PQRS> update(@PathVariable Long id, @RequestBody PQRS pqrs) {
       Optional<PQRS> pqrsOptional = pqrsRepository.findById(id);
       
       if (!pqrsOptional.isPresent()) {
          return ResponseEntity.notFound().build();
       }
       
       pqrs.setId(id);
       pqrsRepository.save(pqrs);
       return ResponseEntity.ok(pqrs);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<PQRS> delete(@PathVariable Long id) {
       Optional<PQRS> pqrsOptional = pqrsRepository.findById(id);
       
       if (!pqrsOptional.isPresent()) {
          return ResponseEntity.notFound().build();
       }
       
       pqrsRepository.delete(pqrsOptional.get());
       return ResponseEntity.ok().build();
    }
}
