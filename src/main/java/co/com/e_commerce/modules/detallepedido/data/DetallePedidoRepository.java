package co.com.e_commerce.modules.detallepedido.data;

import co.com.e_commerce.modules.detallepedido.dto.ProductoCantidadDTO;
import co.com.e_commerce.modules.detallepedido.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    @Query("SELECT dp.producto.id, dp.producto.nombre , SUM(dp.cantidad) as total FROM DetallePedido dp GROUP BY dp.producto.id ORDER BY total DESC LIMIT 5")
    List<ProductoCantidadDTO> findTop5MasVendidos();
}
