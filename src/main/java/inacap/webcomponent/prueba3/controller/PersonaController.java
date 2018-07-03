/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.PersonaModel;
import inacap.webcomponent.prueba3.model.VehiculoModel;
import inacap.webcomponent.prueba3.repository.PersonaRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping("/persona")
public class PersonaController{
        
        @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping()
    public Iterable<PersonaModel> list() {

        return personaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> get(@PathVariable String id){
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if (pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            return new ResponseEntity<>(pEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if (pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            
            personaEditar.setIdPersona(pEncontrado.getIdPersona());
            personaRepository.save(personaEditar);
            
            return new ResponseEntity<>(personaEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }    
    
    @PostMapping
    public ResponseEntity<PersonaModel> post(@RequestBody PersonaModel nuevaPersona) {
       
        nuevaPersona = personaRepository.save(nuevaPersona);
        
        Optional<PersonaModel> pOptional = personaRepository.findById(nuevaPersona.getIdPersona());
        
        if (pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            return new ResponseEntity<>(pEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if (pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            
            personaRepository.deleteById(pEncontrado.getIdPersona());
            
            return new ResponseEntity<>(pEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }
} 