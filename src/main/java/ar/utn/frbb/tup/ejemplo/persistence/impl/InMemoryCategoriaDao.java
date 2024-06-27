package ar.utn.frbb.tup.ejemplo.persistence.impl;

import ar.utn.frbb.tup.ejemplo.controller.CategoriaDto;
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
    public Categoria crearCategoria(CategoriaDto nuevaCategoria) {
        for (Categoria categoria : categorias) {
            if (nuevaCategoria.getNombre().equalsIgnoreCase(categoria.getNombre())) {
                System.out.println("Categoria " + nuevaCategoria.getNombre() + " ya existe.");
                return categoria;
            }
        }
        Categoria categoria = new Categoria(categorias.size() + 1,nuevaCategoria.getNombre(), nuevaCategoria.getDescripcion());
        categorias.add(categoria);
        System.out.println("Categoria creada exitosamente");
        return categoria;
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
