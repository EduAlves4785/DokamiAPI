package io.github.edualves4785.dokamiapi.application.pastas;

import io.github.edualves4785.dokamiapi.application.categorias.CategoriaDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResumoDTO;
import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;

import java.time.LocalDateTime;

public record PastaResponseDTO(
        String id,
        String nome,
        Integer ordem,
        CategoriaResumoDTO categoria,
        UsuarioResumoDTO usuario,
        LocalDateTime dataCriacao,
        LocalDateTime ultimaAlteracao
) {
}
