package ar.utn.frbb.tup.ejemplo.persistence.impl;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.persistence.CategoriaDao;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.persistence.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InMemoryProductoDao implements ProductoDao {
    private final CategoriaDao categoriaDao;
    private ArrayList<Producto> productos = new ArrayList<>();

    @Autowired
    public InMemoryProductoDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Override
    public ArrayList<Producto> findAllProductos() {
        return productos;
    }

    @Override
    public Producto crearProducto(Producto producto) throws NoCategoriasException {
        Categoria categoria = categoriaDao.findByName(producto.getCategory());
        if (categoria == null) {
            throw new NoCategoriasException("La categoria no existe, por favor crear una nueva categoria antes de agregar el producto.");
        }
        producto.setId(productos.size() + 1);
        productos.add(producto);
        categoria.getListProductos().add(producto);
        return producto;
    }

    @Override
    public Producto findById(int id) {
        for(Producto producto : productos) {
            if(producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
}
