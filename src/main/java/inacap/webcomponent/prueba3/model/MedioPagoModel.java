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
 * @author pablo
 */
@Entity
@Table(name = "medio_pago")
public class MedioPagoModel {
    
     @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedioPago;
    private String nombreMedioPago;
    private String detalle;

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
    
    
    
    
}
