package io.github.edualves4785.dokamiapi.application.usuarios;

import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario mapToUsuario(UsuarioDTO dto){
        return Usuario.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .senha(dto.getSenha())
                .build();
    }
}
