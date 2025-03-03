package co.com.e_commerce.modules.login.dto;

public record AuthRequest(
        String fullname,
        String username,
        String password
) {
}
