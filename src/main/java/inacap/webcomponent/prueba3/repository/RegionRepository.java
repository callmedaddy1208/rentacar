/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.repository;

import inacap.webcomponent.prueba3.model.RegionModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author callmedaddy
 */
public interface RegionRepository extends CrudRepository<RegionModel, Integer> {
    
}
