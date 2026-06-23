package io.github.edualves4785.dokamiapi.domain.service;

import io.github.edualves4785.dokamiapi.application.conteudo.ConteudoDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Conteudo;

import java.util.List;

public interface ConteudoService {
    void cadastrarConteudo(ConteudoDTO dto);
    List<Conteudo> findByPasta_Id(String idPasta);

}
