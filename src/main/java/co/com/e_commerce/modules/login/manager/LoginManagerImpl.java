package co.com.e_commerce.modules.login.manager;

import co.com.e_commerce.core.utils.JwtService;
import co.com.e_commerce.modules.login.dto.AuthRequest;
import co.com.e_commerce.modules.login.dto.*;
import co.com.e_commerce.modules.token.data.TokenRepository;
import co.com.e_commerce.modules.token.entity.Token;
import co.com.e_commerce.modules.usuario.data.UsuarioRepository;
import co.com.e_commerce.modules.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginManagerImpl {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;


    public TokenResponse registrar(final AuthRequest request) {
        final Usuario user = Usuario.builder()
                .nombreCompleto(request.fullname())
                .nombreUsuario(request.username())
                .contrasena(passwordEncoder.encode(request.password()))
                .esClienteFrecuente(false)
                .build();

        final Usuario savedUser = usuarioRepository.save(user);
        final String jwtToken = jwtService.generateToken(savedUser);
        final String refreshToken = jwtService.generateRefreshToken(savedUser);

        saveUserToken(savedUser, jwtToken);
        return new TokenResponse(jwtToken, refreshToken, savedUser.getNombreCompleto());
    }

    private void saveUserToken(Usuario user, String jwtToken) {
        final Token token = Token.builder()
                .usuario(user)
                .token(jwtToken)
                .tokenType(Token.TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);
    }

    public TokenResponse authenticate(final AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        final Usuario user = usuarioRepository.findByNombreUsuario(request.username())
                .orElseThrow();
        final String accessToken = jwtService.generateToken(user);
        final String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        return new TokenResponse(accessToken, refreshToken, user.getNombreCompleto());
    }

    private void revokeAllUserTokens(final Usuario user) {
        final List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (!validUserTokens.isEmpty()) {
            validUserTokens.forEach(token -> {
                token.setIsExpired(true);
                token.setIsRevoked(true);
            });
            tokenRepository.saveAll(validUserTokens);
        }
    }
}
