package ar.utn.frbb.tup.ejemplo.controller;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.service.CategoriaService;
import ar.utn.frbb.tup.ejemplo.model.exception.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    @PostMapping
    public Categoria crearCategoria(@RequestBody CategoriaDto categoria) {
        // categoria.getName() <- validator
        return categoriaService.crearCategoria(categoria);
    }

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{categoriaId}")
    public Categoria getCategoria(@PathVariable int id) throws ItemNoEncontradoException {
        return categoriaService.getCategoria(id);
    }


}
