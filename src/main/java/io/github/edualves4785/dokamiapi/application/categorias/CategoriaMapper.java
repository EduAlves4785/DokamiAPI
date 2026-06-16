package io.github.edualves4785.dokamiapi.application.categorias;

import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    public Categoria mapToCategoria(CategoriaDTO dto){
        return Categoria.builder()
                .nome(dto.getNome())
                .ordem(dto.getOrdem())
                .build();
    }

    public CategoriaResponseDTO categoriaToDTO(Categoria categoria){
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getOrdem(),
                new UsuarioResumoDTO(
                        categoria.getUsuario().getId(),
                        categoria.getUsuario().getNome(),
                        categoria.getUsuario().getEmail()
                ),
                categoria.getData_criacao(),
                categoria.getUltima_alteracao()
        );
    }
}
