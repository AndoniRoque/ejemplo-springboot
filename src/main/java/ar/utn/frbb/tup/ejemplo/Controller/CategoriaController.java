package ar.utn.frbb.tup.ejemplo.Controller;

import ar.utn.frbb.tup.ejemplo.Model.Categoria;
import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Service.CategoriaService;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        categoriaService.crearCategoria(categoria);
        return categoria;
    }

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/todas")
    public ArrayList<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/porId")
    public Categoria getCategoria(@RequestParam int id) throws ItemNoEncontradoException {
        return categoriaService.getCategoria(id);
    }
}
