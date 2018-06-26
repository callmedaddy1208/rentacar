/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.CarroceriaModel;
import inacap.webcomponent.prueba3.repository.CarroceriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pablo
 */

@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
     @Autowired
    private CarroceriaRepository carroceriaRepository;
    
    @GetMapping()
    public Iterable<CarroceriaModel> list() {
        return carroceriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaModel> get(@PathVariable String id) {
        Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            CarroceriaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
      
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> put(@PathVariable String id, @RequestBody CarroceriaModel carroceria) {
           Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
           
        if (cOptional.isPresent()){
            CarroceriaModel cEncontrado = cOptional.get();
            carroceria.setIdCarroceria(cEncontrado.getIdCarroceria());
            carroceriaRepository.save(carroceria);
            return new ResponseEntity<>(carroceria, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
       
    }
    
    @PostMapping
    public ResponseEntity<CarroceriaModel> post(@RequestBody CarroceriaModel nuevaCarroceria) {
        
        nuevaCarroceria = carroceriaRepository.save(nuevaCarroceria);
        
        Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(nuevaCarroceria.getIdCarroceria());
        
        if (cOptional.isPresent()){
            CarroceriaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            CarroceriaModel cEncontrado = cOptional.get();
            
            carroceriaRepository.deleteById(cEncontrado.getIdCarroceria());
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    
}