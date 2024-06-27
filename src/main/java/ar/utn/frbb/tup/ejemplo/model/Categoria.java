package ar.utn.frbb.tup.ejemplo.model;

import java.util.ArrayList;
import java.util.Objects;

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

    public Categoria(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id && nombre.equals(categoria.nombre) && descripcion.equals(categoria.descripcion) && Objects.equals(listProductos, categoria.listProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
