package co.com.e_commerce.modules.producto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoBusquedaRequestDTO {
    private String criterio;
    private String valor;
}
