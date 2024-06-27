package ar.utn.frbb.tup.ejemplo.service;

import ar.utn.frbb.tup.ejemplo.controller.CategoriaDto;
import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.model.exception.ItemNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(CategoriaDto categoria);
    Categoria getCategoria(int id) throws ItemNoEncontradoException;
    List<Categoria> getAllCategorias();
}
