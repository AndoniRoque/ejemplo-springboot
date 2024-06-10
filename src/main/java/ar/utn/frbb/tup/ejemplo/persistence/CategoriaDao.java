package ar.utn.frbb.tup.ejemplo.persistence;

import ar.utn.frbb.tup.ejemplo.model.Categoria;

import java.util.ArrayList;

public interface CategoriaDao {
    Categoria crearCategoria(Categoria categoria);
    Categoria findById(int id);
    ArrayList<Categoria> findAllCategorias();
    Categoria findByName(String name);
}
