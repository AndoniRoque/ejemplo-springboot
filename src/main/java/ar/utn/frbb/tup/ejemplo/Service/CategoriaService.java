package ar.utn.frbb.tup.ejemplo.Service;

import ar.utn.frbb.tup.ejemplo.Model.Categoria;
import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;

import java.util.ArrayList;
import java.util.Map;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria getCategoria(int id) throws ItemNoEncontradoException;
    ArrayList<Categoria> getAllCategorias();
}
