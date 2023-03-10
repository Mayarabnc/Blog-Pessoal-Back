package Org.generation.blogPessoal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import Org.generation.blogPessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(String usuario);
}
