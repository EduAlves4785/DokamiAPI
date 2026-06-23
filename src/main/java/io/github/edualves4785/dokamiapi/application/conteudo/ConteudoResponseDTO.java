package io.github.edualves4785.dokamiapi.application.conteudo;

import io.github.edualves4785.dokamiapi.application.pastas.PastaResumoDTO;
import io.github.edualves4785.dokamiapi.application.usuarios.UsuarioResumoDTO;
import io.github.edualves4785.dokamiapi.domain.enums.TipoConteudo;

import java.time.LocalDateTime;

public record ConteudoResponseDTO(
        String id,
        PastaResumoDTO pastaResumoDTO,
        String titulo,
        String descricao,
        TipoConteudo tipo,
        String conteudoTexto,
        String url,
        String caminhoArquivo,
        String extensaoArquivo,
        String tamanhoArquivo,
        UsuarioResumoDTO usuarioResumoDTO,
        LocalDateTime dataCriacao,
        LocalDateTime ultimaAlteracao
) {
}
