package io.github.edualves4785.dokamiapi.application.categorias;

import lombok.Data;

public record CategoriaResumoDTO(
         String id,
         String nome,
         Integer ordem
) {
}