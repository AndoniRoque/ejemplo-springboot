package ar.utn.frbb.tup.ejemplo.Service;

import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Persistencia.Impl.excepciones.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;

import java.util.ArrayList;

public interface ProductoService {
    Producto getProducto(int id) throws ItemNoEncontradoException;
    ArrayList<Producto> getAllProductos();
    Producto crearProducto(Producto producto) throws NoCategoriasException;
}
