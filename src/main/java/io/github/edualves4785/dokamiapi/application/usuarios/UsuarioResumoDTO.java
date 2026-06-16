package io.github.edualves4785.dokamiapi.application.usuarios;

import java.util.UUID;

public record UsuarioResumoDTO(
        String id,
        String nome,
        String email
) {}
