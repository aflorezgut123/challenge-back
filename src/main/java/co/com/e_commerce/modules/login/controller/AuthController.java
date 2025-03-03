package co.com.e_commerce.modules.login.controller;

import co.com.e_commerce.modules.login.dto.AuthRequest;
import co.com.e_commerce.modules.login.dto.TokenResponse;
import co.com.e_commerce.modules.login.manager.LoginManagerImpl;
import co.com.e_commerce.modules.usuario.data.UsuarioRepository;
import co.com.e_commerce.modules.usuario.manager.UsuarioManagerImpl;
import co.com.e_commerce.modules.usuario.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private AuthenticationManager authenticationManager;


    private UsuarioManagerImpl usuarioServicio;


    private final LoginManagerImpl loginManager;

    private final PasswordEncoder passwordEncoder;

    private final UsuarioRepository usuarioRepositorio;

    private final UsuarioMapper usuarioMapper;

    @PostMapping("/registrar")
    public ResponseEntity<TokenResponse> registrar(@RequestBody AuthRequest request) {
        final TokenResponse response = loginManager.registrar(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest request) {
        final TokenResponse response = loginManager.authenticate(request);
        return ResponseEntity.ok(response);
    }

}
