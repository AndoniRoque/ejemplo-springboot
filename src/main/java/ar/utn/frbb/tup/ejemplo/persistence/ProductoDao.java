package ar.utn.frbb.tup.ejemplo.persistence;

import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;

import java.util.ArrayList;
import java.util.List;

public interface ProductoDao {
    Producto crearProducto(Producto product) throws NoCategoriasException;
    Producto findById(int id);
    List<Producto> findAllProductos();
}
