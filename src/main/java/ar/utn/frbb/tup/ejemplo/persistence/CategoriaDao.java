package ar.utn.frbb.tup.ejemplo.persistence;

import ar.utn.frbb.tup.ejemplo.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public interface CategoriaDao {
    Categoria crearCategoria(Categoria categoria);
    Categoria findById(int id);
    List<Categoria> findAllCategorias();
    Categoria findByName(String name);
}
