package io.github.edualves4785.dokamiapi.application.conteudo;

import io.github.edualves4785.dokamiapi.domain.enums.TipoConteudo;
import lombok.Data;

@Data
public class ConteudoDTO {
    private String idPasta;
    private String titulo;
    private String descricao;
    private TipoConteudo tipo;
    private String conteudoTexto;
    private String url;
    private String caminhoArquivo;
    private String extensaoArquivo;
    private String tamanhoArquivo;
}
