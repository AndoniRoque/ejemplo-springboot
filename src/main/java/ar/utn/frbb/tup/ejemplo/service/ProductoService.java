package ar.utn.frbb.tup.ejemplo.service;

import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.service.impl.excepciones.ItemNoEncontradoException;

import java.util.ArrayList;

public interface ProductoService {
    Producto getProducto(int id) throws ItemNoEncontradoException;
    ArrayList<Producto> getAllProductos();
    Producto crearProducto(Producto producto) throws NoCategoriasException;
}
