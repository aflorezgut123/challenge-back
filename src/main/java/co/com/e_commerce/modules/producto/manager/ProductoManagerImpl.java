package co.com.e_commerce.modules.producto.manager;

import co.com.e_commerce.modules.producto.data.ProductoRepository;
import co.com.e_commerce.modules.producto.dto.ProductoDTO;
import co.com.e_commerce.modules.producto.entity.Producto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoManagerImpl implements ProductoManager {

    private final ProductoRepository productoRepository;

    public List<ProductoDTO> listarProductos() {
        List<Producto> listaProducto = productoRepository.findAll();
        return convertirLista(listaProducto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAllProductos();
    }

    private List<ProductoDTO> convertirLista(List<Producto> lista) {
        List<ProductoDTO> listaProducto = new ArrayList<>();
        lista.forEach(d -> listaProducto.add(new ProductoDTO().transformarSinDependencias(d)));
        return listaProducto;
    }
}
