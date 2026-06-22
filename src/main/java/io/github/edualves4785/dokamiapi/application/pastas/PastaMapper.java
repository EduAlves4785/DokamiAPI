package io.github.edualves4785.dokamiapi.application.pastas;

import io.github.edualves4785.dokamiapi.application.categorias.CategoriaDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResponseDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResumoDTO;
import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Pasta;
import org.springframework.stereotype.Component;

@Component
public class PastaMapper {
    public Pasta mapToPasta(PastaDTO dto){
        return Pasta.builder()
                .nome(dto.getNome())
                .ordem(dto.getOrdem())
                .build();
    }

    public PastaResponseDTO pastaToDTO(Pasta pasta){
        return new PastaResponseDTO(
                pasta.getId(),
                pasta.getNome(),
                pasta.getOrdem(),
                new CategoriaResumoDTO(
                        pasta.getCategoria().getId(),
                        pasta.getCategoria().getNome(),
                        pasta.getCategoria().getOrdem()
                ),
                new UsuarioResumoDTO(
                        pasta.getUsuario().getId(),
                        pasta.getUsuario().getNome(),
                        pasta.getUsuario().getEmail()
                ),
                pasta.getData_criacao(),
                pasta.getUltima_alteracao()
        );
    }
}
