package co.com.e_commerce.modules.pedido.dto;

import lombok.Data;

@Data
public class PedidoCantidadDTO {
    private Integer idUsuario;
    private String nombreCliente;
    private Long totalPedidos;

    public PedidoCantidadDTO(Integer idUsuario, String nombreCliente,  Long totalPedidos) {
        this.idUsuario = idUsuario;
        this.nombreCliente = nombreCliente;
        this.totalPedidos = totalPedidos;
    }
}
