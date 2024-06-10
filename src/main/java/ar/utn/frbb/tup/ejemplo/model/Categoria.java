package ar.utn.frbb.tup.ejemplo.model;

import java.util.ArrayList;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> listProductos = new ArrayList<>();

    public Categoria(int id, String name, String descripcion) {
        this.id = id;
        this.nombre = name;
        this.descripcion = descripcion;
    }

    public int getId() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
    }
}
