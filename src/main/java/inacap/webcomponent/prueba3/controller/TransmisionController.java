/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;


import inacap.webcomponent.prueba3.model.TransmisionModel;
import inacap.webcomponent.prueba3.repository.TransmisionRepository;
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
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @GetMapping()
    public Iterable<TransmisionModel> list() {
        
        return transmisionRepository.findAll();
       
    }
   
    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> get(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            TransmisionModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    }    
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            TransmisionModel aEncontrado = aOptional.get();
            
            transmisionEditar.setIdTransmision(aEncontrado.getIdTransmision());
            transmisionRepository.save(transmisionEditar);
            
            return new ResponseEntity<>(transmisionEditar, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }
    
    @PostMapping
    public ResponseEntity<TransmisionModel> post(@RequestBody TransmisionModel  nuevaTransmision) {
        
        nuevaTransmision = transmisionRepository.save(nuevaTransmision);
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(nuevaTransmision.getIdTransmision());
        
        if (aOptional.isPresent()){
            TransmisionModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            TransmisionModel aEncontrado = aOptional.get();
            
            transmisionRepository.deleteById(aEncontrado.getIdTransmision());
            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
}
    
}
