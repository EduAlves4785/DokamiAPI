package io.github.edualves4785.dokamiapi.application.pastas;

import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Pasta;
import io.github.edualves4785.dokamiapi.domain.entities.service.PastaService;
import io.github.edualves4785.dokamiapi.domain.entities.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.CategoriaRepository;
import io.github.edualves4785.dokamiapi.infra.repository.PastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PastaServiceImpl implements PastaService {

    private final PastaRepository repository;
    private final UsuarioService usuarioService;
    private final CategoriaRepository categoriaRepository;
    private final PastaMapper pastaMapper;

    @Override
    public void criarPasta(PastaDTO dto) {
        Pasta pasta=pastaMapper.mapToPasta(dto);
        pasta.setUsuario(usuarioService.getUsuarioLogado());
        pasta.setCategoria(categoriaRepository.getReferenceById(dto.getIdCategoria()));
        repository.save(pasta);
    }

    @Override
    public List<Pasta> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
