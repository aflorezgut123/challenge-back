package co.com.e_commerce.modules.producto.controller;


import co.com.e_commerce.modules.producto.entity.Producto;
import co.com.e_commerce.modules.producto.manager.ProductoManagerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoManagerImpl productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.obtenerTodosLosProductos();
    }
}
