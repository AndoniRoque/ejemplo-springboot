package ar.utn.frbb.tup.ejemplo.service.impl;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.persistence.CategoriaDao;
import ar.utn.frbb.tup.ejemplo.service.CategoriaService;
import ar.utn.frbb.tup.ejemplo.model.exception.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Categoria> getAllCategorias() {
        return categoriaDao.findAllCategorias();
    }
}
