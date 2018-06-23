/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author callmedaddy
 */

@Entity
@Table(name ="combustibles")

public class CombustibleModel {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idCombustible;
    
     private String nombreCombustible;
    private String detalle;

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getNombreCombustible() {
        return nombreCombustible;
    }

    public void setNombreCombustible(String nombreCombustible) {
        this.nombreCombustible = nombreCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String nombreCombustible, String detalle) {
        this.nombreCombustible = nombreCombustible;
        this.detalle = detalle;
    }

    public CombustibleModel(int idCombustible, String nombreCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.nombreCombustible = nombreCombustible;
        this.detalle = detalle;
    }

 
    
}

