package ar.utn.frbb.tup.ejemplo.service;

import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.model.exception.ItemNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface ProductoService {
    Producto getProducto(int id) throws ItemNoEncontradoException;
    List<Producto> getAllProductos();
    Producto crearProducto(Producto producto) throws NoCategoriasException;
}
