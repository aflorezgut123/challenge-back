package co.com.e_commerce.modules.pedido.data;

import co.com.e_commerce.modules.pedido.dto.PedidoCantidadDTO;
import co.com.e_commerce.modules.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("SELECT new co.com.e_commerce.modules.pedido.dto.PedidoCantidadDTO(p.usuario.id, p.usuario.nombreCompleto, COUNT(p.idPedido)) FROM Pedido p GROUP BY p.usuario ORDER BY COUNT(p.idPedido) DESC LIMIT 5")
    List<PedidoCantidadDTO> findTop5ClientesFrecuentes();
}
