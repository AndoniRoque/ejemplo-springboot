package ar.utn.frbb.tup.ejemplo.Persistencia;

import ar.utn.frbb.tup.ejemplo.Model.Categoria;
import ar.utn.frbb.tup.ejemplo.Model.Producto;

import java.util.ArrayList;

public interface CategoriaDao {
    Categoria crearCategoria(Categoria categoria);
    Categoria findById(int id);
    ArrayList<Categoria> findAllCategorias();
}
