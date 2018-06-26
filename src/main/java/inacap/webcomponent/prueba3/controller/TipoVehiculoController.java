/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.controller;

import inacap.webcomponent.prueba3.model.TipoVehiculoModel;
import inacap.webcomponent.prueba3.model.TraccionModel;
import inacap.webcomponent.prueba3.repository.TipoVehiculoRepository;
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
@RequestMapping("/tipo_vehiculo")


public class TipoVehiculoController {
    
     @Autowired
    private TipoVehiculoRepository tipovehiculoRepository;
     
     @GetMapping()
    public Iterable<TipoVehiculoModel> list() {
        return tipovehiculoRepository.findAll();
    }
     
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> get(@PathVariable String id) {
        Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
      
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipo_vehiculo) {
           Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
           
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            tipo_vehiculo.setIdTipoVehiculo(cEncontrado.getIdTipoVehiculo());
            tipovehiculoRepository.save(tipo_vehiculo);
            return new ResponseEntity<>(tipo_vehiculo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
       
    }
    
    @PostMapping
    public ResponseEntity<TipoVehiculoModel> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
        
        nuevoTipoVehiculo = tipovehiculoRepository.save(nuevoTipoVehiculo);
        
        Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());
        
        if (cOptional.isPresent()){
           TipoVehiculoModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            
           tipovehiculoRepository.deleteById(cEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
