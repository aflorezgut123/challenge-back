package co.com.e_commerce.modules.usuario.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;
    private Boolean esClienteFrecuente;
}
