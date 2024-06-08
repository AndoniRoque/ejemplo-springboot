package ar.utn.frbb.tup.ejemplo.Service.impl;

import ar.utn.frbb.tup.ejemplo.Model.Categoria;
import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Persistencia.CategoriaDao;
import ar.utn.frbb.tup.ejemplo.Persistencia.ProductoDao;
import ar.utn.frbb.tup.ejemplo.Service.CategoriaService;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Autowired
    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaDao.crearCategoria(categoria);
    }

    @Override
    public Categoria getCategoria(int id) throws ItemNoEncontradoException {
        Categoria categoria = categoriaDao.findById(id);
        if(categoria == null) {
            throw new ItemNoEncontradoException("No existe la categoría buscada.");
        }
        return categoria;
    }

    @Override
    public ArrayList<Categoria> getAllCategorias() {
        return categoriaDao.findAllCategorias();
    }
}
