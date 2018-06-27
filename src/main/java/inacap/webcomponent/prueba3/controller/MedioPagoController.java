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
import inacap.webcomponent.prueba3.model.MedioPagoModel;
import inacap.webcomponent.prueba3.repository.MedioPagoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    @GetMapping()
    public Iterable<MedioPagoModel> list() {

        return medioPagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> get(@PathVariable String id) {

        Optional<MedioPagoModel> mpOptional = medioPagoRepository.findById(Integer.parseInt(id));

        if (mpOptional.isPresent()) {
            MedioPagoModel mpEncontrado = mpOptional.get();
            return new ResponseEntity<>(mpEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel medioPagoEditar) {

        Optional<MedioPagoModel> mpOptional = medioPagoRepository.findById(Integer.parseInt(id));

        if (mpOptional.isPresent()) {
            MedioPagoModel mpEncontrado = mpOptional.get();

            medioPagoEditar.setIdMedioPago(mpEncontrado.getIdMedioPago());
            medioPagoRepository.save(medioPagoEditar);

            return new ResponseEntity<>(medioPagoEditar, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }

    }

    @PostMapping
    public ResponseEntity<MedioPagoModel> post(@RequestBody MedioPagoModel nuevoMedioPago) {
       
        nuevoMedioPago = medioPagoRepository.save(nuevoMedioPago);
        
        Optional<MedioPagoModel> mpOptional = medioPagoRepository.findById(nuevoMedioPago.getIdMedioPago());
        
        if (mpOptional.isPresent()){
            MedioPagoModel mpEncontrado = mpOptional.get();
            return new ResponseEntity<>(mpEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        Optional<MedioPagoModel> cOptional = medioPagoRepository.findById(Integer.parseInt(id));
        
        if (cOptional.isPresent()){
            MedioPagoModel mpEncontrado = cOptional.get();
            
            medioPagoRepository.deleteById(mpEncontrado.getIdMedioPago());
            
            return new ResponseEntity<>(mpEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
     }

}
