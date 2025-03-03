package co.com.e_commerce.modules.reporte.manager;

import co.com.e_commerce.modules.detallepedido.data.DetallePedidoRepository;
import co.com.e_commerce.modules.detallepedido.dto.ProductoCantidadDTO;
import co.com.e_commerce.modules.pedido.data.PedidoRepository;
import co.com.e_commerce.modules.pedido.dto.PedidoCantidadDTO;
import co.com.e_commerce.modules.producto.data.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteManagerImpl {

    private final ProductoRepository productoRepository;

    private final PedidoRepository pedidoRepository;

    private final DetallePedidoRepository detallePedidoRepository;

    public List<ProductoCantidadDTO> getTop5MasVendidos() {
        return detallePedidoRepository.findTop5MasVendidos();
    }

    public List<PedidoCantidadDTO> getTop5ClientesFrecuentes() {
        return pedidoRepository.findTop5ClientesFrecuentes();
    }
}