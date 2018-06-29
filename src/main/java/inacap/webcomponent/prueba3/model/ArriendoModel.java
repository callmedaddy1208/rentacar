/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba3.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class ArriendoModel {
    
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;

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
