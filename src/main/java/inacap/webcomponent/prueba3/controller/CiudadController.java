/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.CiudadModel;
import inacap.webcomponent.prueba3.repository.CiudadRepository;
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
 * @author CallMeDaddy
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
        
     @Autowired
    private CiudadRepository ciudadRepository;
    
    @GetMapping()
    public Iterable<CiudadModel> list() {
       
         return ciudadRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> get(@PathVariable String id){
        
        Optional<CiudadModel> eOptional = ciudadRepository.findById(Integer.parseInt(id));
        
        if (eOptional.isPresent()){
            CiudadModel eEncontrado = eOptional.get();
            return new ResponseEntity<>(eEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> put(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
        
        Optional<CiudadModel> eOptional = ciudadRepository.findById(Integer.parseInt(id));
        
        if (eOptional.isPresent()){
            CiudadModel eEncontrado = eOptional.get();
            
            ciudadEditar.setIdCiudad(eEncontrado.getIdCiudad());
            ciudadRepository.save(ciudadEditar);
            
            return new ResponseEntity<>(ciudadEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }   
    
    @PostMapping
    public ResponseEntity<CiudadModel> post(@RequestBody CiudadModel nuevaCiudad) {
       
        nuevaCiudad = ciudadRepository.save(nuevaCiudad);
        
        Optional<CiudadModel> eOptional = ciudadRepository.findById(nuevaCiudad.getIdCiudad());
        
        if (eOptional.isPresent()){
            CiudadModel eEncontrado = eOptional.get();
            return new ResponseEntity<>(eEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<CiudadModel> eOptional = ciudadRepository.findById(Integer.parseInt(id));
        
        if (eOptional.isPresent()){
            CiudadModel eEncontrado = eOptional.get();
            
            ciudadRepository.deleteById(eEncontrado.getIdCiudad());
            
            return new ResponseEntity<>(eEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }
}   

