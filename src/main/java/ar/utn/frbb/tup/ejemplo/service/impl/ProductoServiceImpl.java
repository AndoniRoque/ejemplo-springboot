package ar.utn.frbb.tup.ejemplo.service.impl;

import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.persistence.ProductoDao;
import ar.utn.frbb.tup.ejemplo.service.ProductoService;
import ar.utn.frbb.tup.ejemplo.service.impl.excepciones.ItemNoEncontradoException;
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
