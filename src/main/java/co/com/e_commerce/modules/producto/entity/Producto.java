package co.com.e_commerce.modules.producto.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="producto")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(nullable = false)
    private boolean activo;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String descripcion;
}
