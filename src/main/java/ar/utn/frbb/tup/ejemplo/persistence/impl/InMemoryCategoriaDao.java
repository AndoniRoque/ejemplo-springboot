package ar.utn.frbb.tup.ejemplo.persistence.impl;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.persistence.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryCategoriaDao implements CategoriaDao {
    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public List<Categoria> findAllCategorias() {
        return categorias;
    }

    @Override
    public Categoria crearCategoria(Categoria nuevaCategoria) {
        for (Categoria categoria : categorias) {
            if (nuevaCategoria.getNombre().equalsIgnoreCase(categoria.getNombre())) {
                System.out.println("Categoria " + nuevaCategoria.getNombre() + " ya existe.");
                return categoria;
            }
        }
        nuevaCategoria.setId(categorias.size() + 1);
        categorias.add(nuevaCategoria);
        System.out.println("Categoria creada exitosamente");
        return nuevaCategoria;
    }

    @Override
    public Categoria findById(int id) {
        for (Categoria categoria : categorias) {
            if(categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    @Override
    public Categoria findByName(String name) {
        for(Categoria categoria : categorias){
            if(categoria.getNombre().equalsIgnoreCase(name)){
                return categoria;
            }
        }
        return null;
    }



}
