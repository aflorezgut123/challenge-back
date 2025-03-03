package co.com.e_commerce.modules.detallepedido.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoCantidadDTO {
    private Integer productoId;
    private String nombreProducto;
    private Long totalCantidad;

    public ProductoCantidadDTO(Integer productoId, String nombreProducto, Long totalCantidad) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.totalCantidad = totalCantidad;
    }
}
