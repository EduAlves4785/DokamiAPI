package io.github.edualves4785.dokamiapi.application.conteudo;

import io.github.edualves4785.dokamiapi.application.categorias.CategoriaDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResponseDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResumoDTO;
import io.github.edualves4785.dokamiapi.application.pastas.PastaResumoDTO;
import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Conteudo;
import org.springframework.stereotype.Component;

@Component
public class ConteudoMapper {
    public Conteudo mapToConteudo(ConteudoDTO dto){
        return Conteudo.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .tipo(dto.getTipo())
                .conteudo_texto(dto.getConteudoTexto())
                .url(dto.getUrl())
                .caminho_arquivo(dto.getCaminhoArquivo())
                .extensao_arquivo(dto.getExtensaoArquivo())
                .tamanho_arquivo(dto.getTamanhoArquivo())
                .build();
    }

    public ConteudoResponseDTO conteudoToDTO(Conteudo conteudo){
        return new ConteudoResponseDTO(
                conteudo.getId(),
                new PastaResumoDTO(
                        conteudo.getPasta().getId(),
                        conteudo.getPasta().getNome()
                ),
                conteudo.getTitulo(),
                conteudo.getDescricao(),
                conteudo.getTipo(),
                conteudo.getConteudo_texto(),
                conteudo.getUrl(),
                conteudo.getCaminho_arquivo(),
                conteudo.getExtensao_arquivo(),
                conteudo.getTamanho_arquivo(),
                new UsuarioResumoDTO(
                       conteudo.getUsuario().getId(),
                       conteudo.getUsuario().getNome(),
                       conteudo.getUsuario().getEmail()
                ),
                conteudo.getData_criacao(),
                conteudo.getUltima_alteracao()
        );
    }
}
