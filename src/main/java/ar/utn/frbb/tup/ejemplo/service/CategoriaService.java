package ar.utn.frbb.tup.ejemplo.service;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.service.impl.excepciones.ItemNoEncontradoException;

import java.util.ArrayList;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria getCategoria(int id) throws ItemNoEncontradoException;
    ArrayList<Categoria> getAllCategorias();
}
