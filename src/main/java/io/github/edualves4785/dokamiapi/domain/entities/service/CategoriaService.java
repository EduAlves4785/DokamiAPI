package io.github.edualves4785.dokamiapi.domain.entities.service;

import io.github.edualves4785.dokamiapi.application.categorias.CategoriaDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoriaService {
    void cadastrarCategoria(Categoria categoria);
    List<Categoria> findAll();
    void deleteById(String id);
    Categoria atualizar(CategoriaDTO dto, String id);
}
