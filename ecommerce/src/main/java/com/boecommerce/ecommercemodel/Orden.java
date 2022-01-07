package com.boecommerce.ecommercemodel;

import java.util.Date;



public class Orden {
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibido;

    private Double total;

    public Orden() {
      
    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibido, Double total) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibido = fechaRecibido;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden [fechaCreacion=" + fechaCreacion + ", fechaRecibido=" + fechaRecibido + ", id=" + id + ", numero="
                + numero + ", total=" + total + "]";
    }


    

    

    

    
}
