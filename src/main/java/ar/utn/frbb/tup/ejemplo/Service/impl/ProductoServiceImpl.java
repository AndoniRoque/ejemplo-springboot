package ar.utn.frbb.tup.ejemplo.Service.impl;

import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Persistencia.Impl.excepciones.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.Persistencia.ProductoDao;
import ar.utn.frbb.tup.ejemplo.Service.ProductoService;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoDao productoDao;

    @Override
    public Producto getProducto(int id) throws ItemNoEncontradoException {
        Producto producto = productoDao.findById(id);
        if(producto == null) {
            throw new ItemNoEncontradoException("No existe ese producto.");
        }
        return producto;
    }

    @Override
    public ArrayList<Producto> getAllProductos() {
        return productoDao.findAllProductos();
    }

    @Override
    public Producto crearProducto(Producto product) throws NoCategoriasException {
        return productoDao.crearProducto(product);
    }
}
