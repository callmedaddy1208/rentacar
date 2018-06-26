/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.RegionModel;
import inacap.webcomponent.prueba3.repository.RegionRepository;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author callmedaddy
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
        @Autowired
    private RegionRepository regionRepository;
    
    @GetMapping()
    public Iterable<RegionModel> list() {
       
         return regionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> get(@PathVariable String id){
        
        Optional<RegionModel> cOptional = regionRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            RegionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> put(@PathVariable String id, @RequestBody RegionModel regionEditar) {
        
        Optional<RegionModel> cOptional = regionRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            RegionModel cEncontrado = cOptional.get();
            
            regionEditar.setIdRegion(cEncontrado.getIdRegion());
            regionRepository.save(regionEditar);
            
            return new ResponseEntity<>(regionEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }    
    
    @PostMapping
    public ResponseEntity<RegionModel> post(@RequestBody RegionModel nuevaRegion) {
       
        nuevaRegion = regionRepository.save(nuevaRegion);
        
        Optional<RegionModel> cOptional = regionRepository.findById(nuevaRegion.getIdRegion());
        
        if (cOptional.isPresent()){
            RegionModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<RegionModel> cOptional = regionRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            RegionModel cEncontrado = cOptional.get();
            
            regionRepository.deleteById(cEncontrado.getIdRegion());
            
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }
}   
