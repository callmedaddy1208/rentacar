/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.prueba3.model.ArriendoModel;

/**
 *
 * @author Administrador
 */
public interface ArriendoRepository extends CrudRepository<ArriendoModel, Integer> {
    
}
