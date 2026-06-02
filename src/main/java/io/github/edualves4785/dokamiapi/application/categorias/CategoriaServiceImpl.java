package io.github.edualves4785.dokamiapi.application.categorias;

import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.service.CategoriaService;
import io.github.edualves4785.dokamiapi.infra.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    @Transactional
    public void cadastrarCategoria(Categoria categoria) {
        repository.save(categoria);
    }
}
