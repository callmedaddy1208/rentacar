/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.TipoPersonaModel;
import inacap.webcomponent.prueba3.model.TipoVehiculoModel;
import inacap.webcomponent.prueba3.repository.TipoPersonaRepository;
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
@RequestMapping("/tipo_persona")

public class TipoPersonaController {
    
@Autowired

private TipoPersonaRepository tipopersonaRepository;

@GetMapping()
    public Iterable<TipoPersonaModel> list() {
        return tipopersonaRepository.findAll();
    }

@GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> get(@PathVariable String id) {
        Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
        @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> put(@PathVariable String id, @RequestBody TipoPersonaModel tipo_persona) {
           Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
           
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            tipo_persona.setIdTipoPersona(cEncontrado.getIdTipoPersona());
            tipopersonaRepository.save(tipo_persona);
            return new ResponseEntity<>(tipo_persona, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }


    }
    
    @PostMapping
    public ResponseEntity<TipoPersonaModel> post(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        
        nuevoTipoPersona = tipopersonaRepository.save(nuevoTipoPersona);
        
        Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(nuevoTipoPersona.getIdTipoPersona());
        
        if (cOptional.isPresent()){
           TipoPersonaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
       @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoPersonaModel> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            TipoPersonaModel cEncontrado = cOptional.get();
            
           tipopersonaRepository.deleteById(cEncontrado.getIdTipoPersona());
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}
    
    
    
    
    

