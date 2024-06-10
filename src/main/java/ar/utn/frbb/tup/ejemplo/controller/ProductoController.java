package ar.utn.frbb.tup.ejemplo.controller;

import ar.utn.frbb.tup.ejemplo.model.Producto;
import ar.utn.frbb.tup.ejemplo.model.exception.NoCategoriasException;
import ar.utn.frbb.tup.ejemplo.service.ProductoService;
import ar.utn.frbb.tup.ejemplo.service.impl.excepciones.ItemNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{productId}")
    public Producto getProducto(@PathVariable int id) throws ItemNoEncontradoException {
        return productoService.getProducto(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) throws NoCategoriasException {
        return productoService.crearProducto(producto);
    }
}
