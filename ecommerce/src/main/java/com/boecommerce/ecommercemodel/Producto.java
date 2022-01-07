package com.boecommerce.ecommercemodel;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int contidad;


    public Producto() {
    }


    public Producto(Integer id, String nombre, String descripcion, String imagen, double precio, int contidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.contidad = contidad;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getImagen() {
        return imagen;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getContidad() {
        return contidad;
    }


    public void setContidad(int contidad) {
        this.contidad = contidad;
    }


    @Override
    public String toString() {
        return "Producto [contidad=" + contidad + ", descripcion=" + descripcion + ", id=" + id + ", imagen=" + imagen
                + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    
    

    
    
}
