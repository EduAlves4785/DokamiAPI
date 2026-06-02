package io.github.edualves4785.dokamiapi.infra.repository;

import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
