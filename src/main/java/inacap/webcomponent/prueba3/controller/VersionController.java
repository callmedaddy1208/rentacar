/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.prueba3.model.VersionModel;
import inacap.webcomponent.prueba3.repository.VersionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
    @Autowired
    private VersionRepository versionRepository;
    
    @GetMapping()
    public Iterable<VersionModel> list() {
       
         return versionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VersionModel> get(@PathVariable String id){
        
        Optional<VersionModel> vOptional = versionRepository.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()){
            VersionModel vEncontrado = vOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VersionModel> put(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        
        Optional<VersionModel> vOptional = versionRepository.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()){
            VersionModel vEncontrado = vOptional.get();
            
            versionEditar.setIdVersion(vEncontrado.getIdVersion());
            versionRepository.save(versionEditar);
            
            return new ResponseEntity<>(versionEditar, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    
   }  
    
    @PostMapping
    public ResponseEntity<VersionModel> post(@RequestBody VersionModel nuevaVersion) {
       
        nuevaVersion = versionRepository.save(nuevaVersion);
        
        Optional<VersionModel> vOptional = versionRepository.findById(nuevaVersion.getIdVersion());
        
        if (vOptional.isPresent()){
            VersionModel vEncontrado = vOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<VersionModel> vOptional = versionRepository.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()){
            VersionModel aEncontrado = vOptional.get();
            
            versionRepository.deleteById(aEncontrado.getIdVersion());
            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     } 
}
