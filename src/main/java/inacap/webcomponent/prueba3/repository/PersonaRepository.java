/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.repository;

import inacap.webcomponent.prueba3.model.PersonaModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CallMeDaddy
 */
public interface PersonaRepository extends CrudRepository<PersonaModel, Integer> {
    
}
