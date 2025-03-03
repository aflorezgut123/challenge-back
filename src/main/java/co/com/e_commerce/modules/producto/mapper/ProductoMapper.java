package co.com.e_commerce.modules.producto.mapper;

import co.com.e_commerce.modules.producto.dto.ProductoDTO;
import co.com.e_commerce.modules.producto.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public static ProductoDTO convertirADTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setActivo(producto.isActivo());
        return productoDTO;
    }

    public Producto convertirAEntidad(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setActivo(productoDTO.isActivo());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        return producto;
    }
}
