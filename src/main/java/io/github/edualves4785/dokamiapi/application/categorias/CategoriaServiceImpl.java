package io.github.edualves4785.dokamiapi.application.categorias;

import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.service.CategoriaService;
import io.github.edualves4785.dokamiapi.domain.entities.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final UsuarioService usuarioService;

    @Override
    @Transactional
    public void cadastrarCategoria(Categoria categoria) {
        categoria.setUsuario(usuarioService.getUsuarioLogado());
        repository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
        return  repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
