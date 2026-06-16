package io.github.edualves4785.dokamiapi.application.categorias;

import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoriaResponseDTO(
        String id,
        String nome,
        Integer ordem,
        UsuarioResumoDTO usuario,
        LocalDateTime dataCriacao,
        LocalDateTime ultimaAlteracao
) {}
