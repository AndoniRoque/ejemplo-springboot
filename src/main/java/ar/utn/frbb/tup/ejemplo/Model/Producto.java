package ar.utn.frbb.tup.ejemplo.Model;

import java.util.ArrayList;
import java.util.Map;

public class Producto {
    private int id;
    private String nombre;
    private Double precio;
    private Map<String, String> especificaciones;
    private String category_name;


    public Producto(int id, String nombre, Double precio, Map<String, String> especificiaciones, String category_name) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.especificaciones = especificiaciones;
        this.category_name = category_name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Map<String, String> especificiaciones) {
        this.especificaciones = especificiaciones;
    }

    public String getCategory() {
        return category_name;
    }

    public void setCategory(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", especificiaciones=" + especificaciones +
                '}';
    }
}
