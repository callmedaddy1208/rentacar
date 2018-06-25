/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.MarcaModel;
import inacap.webcomponent.prueba3.repository.MarcaRepository;
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
 * @author callmedaddy
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
        
        @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping()
    public Iterable<MarcaModel> list() {
       
         return marcaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> get(@PathVariable String id){
        
        Optional<MarcaModel> bOptional = marcaRepository.findById(Integer.parseInt(id));
        
        if (bOptional.isPresent()){
            MarcaModel bEncontrado = bOptional.get();
            return new ResponseEntity<>(bEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> put(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        
        Optional<MarcaModel> bOptional = marcaRepository.findById(Integer.parseInt(id));
        
        if (bOptional.isPresent()){
            MarcaModel bEncontrado = bOptional.get();
            
            marcaEditar.setIdMarca(bEncontrado.getIdMarca());
            marcaRepository.save(marcaEditar);
            
            return new ResponseEntity<>(marcaEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }   
    
    @PostMapping
    public ResponseEntity<MarcaModel> post(@RequestBody MarcaModel nuevaMarca) {
       
        nuevaMarca = marcaRepository.save(nuevaMarca);
        
        Optional<MarcaModel> bOptional = marcaRepository.findById(nuevaMarca.getIdMarca());
        
        if (bOptional.isPresent()){
            MarcaModel bEncontrado = bOptional.get();
            return new ResponseEntity<>(bEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<MarcaModel> bOptional = marcaRepository.findById(Integer.parseInt(id));
        
        if (bOptional.isPresent()){
            MarcaModel bEncontrado = bOptional.get();
            
            marcaRepository.deleteById(bEncontrado.getIdMarca());
            
            return new ResponseEntity<>(bEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }
}   


    