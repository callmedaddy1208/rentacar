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
    
    
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private PersonaModel vendedor;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private PersonaModel cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoModel vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id_medio_pago")
    private MedioPagoModel medioPago;

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo) {
        this.fechaArriendo = fechaArriendo;
       
    }

    public ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
      
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

    
      
    

}
