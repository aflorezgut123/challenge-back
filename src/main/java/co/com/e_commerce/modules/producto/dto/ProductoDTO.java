package co.com.e_commerce.modules.producto.dto;

import co.com.e_commerce.modules.producto.entity.Producto;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;

@Data
public class ProductoDTO{
    private Integer id;
    private boolean activo;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String descripcion;

    public ProductoDTO transformarSinDependencias(Producto obj){
        ProductoDTO dto = new ProductoDTO();
        dto.setId(obj.getId());
        dto.setActivo(obj.isActivo());
        dto.setNombre(obj.getNombre());
        dto.setPrecio(obj.getPrecio());
        dto.setStock(obj.getStock());
        dto.setDescripcion(obj.getDescripcion());
        return dto;
    }

}
