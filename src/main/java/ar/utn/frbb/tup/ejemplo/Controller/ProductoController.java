package ar.utn.frbb.tup.ejemplo.Controller;

import ar.utn.frbb.tup.ejemplo.Model.Producto;
import ar.utn.frbb.tup.ejemplo.Persistencia.Impl.excepciones.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.Service.ProductoService;
import ar.utn.frbb.tup.ejemplo.Service.impl.excepciones.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/todos")
    public ArrayList<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/porId")
    public Producto getProducto(@RequestParam int id) throws ItemNoEncontradoException {
        return productoService.getProducto(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) throws NoCategoriasException {
        return productoService.crearProducto(producto);
    }
}
