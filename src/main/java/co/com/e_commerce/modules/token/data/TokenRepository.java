package co.com.e_commerce.modules.token.data;

import co.com.e_commerce.modules.token.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join Usuario u\s
      on t.usuario.id = u.id\s
      where u.id = :id and (t.isExpired = false or t.isRevoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Integer id);

    Optional<Token> findByToken(String token);
    void deleteByUsuarioId(Integer usuarioId);
}
