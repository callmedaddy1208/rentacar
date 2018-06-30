/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
 @Table(name="arriendo")
public class ArriendoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonaModel vendedor;
    @ManyToOne
    @JoinColumn(name = "id_")
    private PersonaModel cliente;
    
    private VehiculoModel vehiculo;
    private MedioPagoModel medioPago;

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
    }

    public ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
    }

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }
    
    
    
    
    
    
}
