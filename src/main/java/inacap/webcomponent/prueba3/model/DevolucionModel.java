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
import javax.persistence.Table;

/**
 *
 * @author CallMeDaddy
 */

@Entity
@Table(name = "devolucion")
public class DevolucionModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int idDevolucion;
    private Date fechaDevolucion;
    private Time horaDevolucion;

    public DevolucionModel() {
    }

    public DevolucionModel(Date fechaDevolucion, Time horaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
    }
    
    
    

    public DevolucionModel(int idDevolucion, Date fechaDevolucion, Time horaDevolucion) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
    }

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Time getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }
    
    
    
    
    
    
    
    
    
}
