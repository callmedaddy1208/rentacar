/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.repository;

import inacap.webcomponent.prueba3.model.CarroceriaModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pablo
 */
public interface CarroceriaRepository extends CrudRepository<CarroceriaModel, Integer> {
    
}
