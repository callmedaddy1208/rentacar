/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.CombustibleModel;
import inacap.webcomponent.prueba3.repository.CombustibleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
 * @author callmedaddy
 */
@RestController
@RequestMapping("/combustibles")
public class CombustibleController {
    
    @Autowired
    private CombustibleRepository combustibleRepository;
    
    @GetMapping()
    public Iterable<CombustibleModel> list() {
       
         return combustibleRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> get(@PathVariable String id) {
        
        Optional<CombustibleModel> rOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (rOptional.isPresent()){
            CombustibleModel rEncontrado = rOptional.get();
            return new ResponseEntity<>(rEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
   public ResponseEntity<CombustibleModel> put(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {
        
        Optional<CombustibleModel> rOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (rOptional.isPresent()){
            CombustibleModel rEncontrado = rOptional.get();
            
            combustibleEditar.setIdCombustible(rEncontrado.getIdCombustible());
            combustibleRepository.save(combustibleEditar);
            
            return new ResponseEntity<>(combustibleEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }    
    
    @PostMapping
    public ResponseEntity<CombustibleModel> post(@RequestBody CombustibleModel nuevoCombustible) {
       
        nuevoCombustible = combustibleRepository.save(nuevoCombustible);
        
        Optional<CombustibleModel> rOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());
        
        if (rOptional.isPresent()){
            CombustibleModel rEncontrado = rOptional.get();
            return new ResponseEntity<>(rEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<CombustibleModel> rOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (rOptional.isPresent()){
            CombustibleModel rEncontrado = rOptional.get();
            
            combustibleRepository.deleteById(rEncontrado.getIdCombustible());
            
            return new ResponseEntity<>(rEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }
}   
