package ar.utn.frbb.tup.ejemplo.model;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && nombre.equals(producto.nombre) && precio.equals(producto.precio) && Objects.equals(category_name, producto.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, category_name);
    }
}
