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
    private ArrayList<Categoria> categorias;
    private Categoria categoria;
    private ArrayList<Producto> productos = new ArrayList<>();

    @Autowired
    public InMemoryProductoDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
        this.categorias = categoriaDao.findAllCategorias();
        this.categoria = categorias.isEmpty() ? null : categorias.get(0);
        this.productos = new ArrayList<>();
    }

    @Override
    public ArrayList<Producto> findAllProductos() {
        return productos;
    }

    @Override
    public Producto crearProducto(Producto producto) throws NoCategoriasException {
        boolean categoriaFound = false;
        if (categorias.isEmpty()) {
            throw new NoCategoriasException("No hay categorias cargadas, por favor crear una categoria nueva.");
        } else {
            for (Categoria categoria : categorias) {
                if (producto.getCategory().equalsIgnoreCase(categoria.getNombre())) {
                    producto.setId(productos.size() + 1);
                    productos.add(producto);
                    categoria.getListProductos().add(producto);
                    categoriaFound = true;
                }
            }
        }
        if(!categoriaFound) {
            throw new NoCategoriasException("La categoria no existe, por favor crear una nueva categoria antes de agregar el producto.");
        }
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
