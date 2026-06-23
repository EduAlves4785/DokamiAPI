package io.github.edualves4785.dokamiapi.domain.service;

import io.github.edualves4785.dokamiapi.application.pastas.PastaDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Pasta;

import java.util.List;

public interface PastaService {
    void criarPasta(PastaDTO dto);
    List<Pasta> findAll();
    void deleteById(String id);
    Pasta atualizar(PastaDTO dto, String id);
}
