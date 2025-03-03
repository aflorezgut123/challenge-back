package co.com.e_commerce.modules.reporte.controller;

import co.com.e_commerce.modules.detallepedido.dto.ProductoCantidadDTO;
import co.com.e_commerce.modules.pedido.dto.PedidoCantidadDTO;
import co.com.e_commerce.modules.reporte.manager.ReporteManagerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reporte")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteManagerImpl reporteService;

    @GetMapping("/top-5-mas-vendidos")
    public List<ProductoCantidadDTO> getTop5MasVendidos() {
        return reporteService.getTop5MasVendidos();
    }

    @GetMapping("/top-5-clientes-frecuentes")
    public List<PedidoCantidadDTO> getTop5ClientesFrecuentes() {
        return reporteService.getTop5ClientesFrecuentes();
    }
}
