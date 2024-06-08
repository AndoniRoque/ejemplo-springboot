package ar.utn.frbb.tup.ejemplo.Persistencia;

import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Persistencia.Impl.excepciones.NoCategoriasException;

import java.util.ArrayList;

public interface ProductoDao {
    Producto crearProducto(Producto product) throws NoCategoriasException;
    Producto findById(int id);
    ArrayList<Producto> findAllProductos();
}
