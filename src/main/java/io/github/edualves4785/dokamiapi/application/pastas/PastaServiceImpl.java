package io.github.edualves4785.dokamiapi.application.pastas;

import io.github.edualves4785.dokamiapi.domain.entities.Pasta;
import io.github.edualves4785.dokamiapi.domain.service.PastaService;
import io.github.edualves4785.dokamiapi.domain.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.CategoriaRepository;
import io.github.edualves4785.dokamiapi.infra.repository.PastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Override
    @Transactional
    public Pasta atualizar(PastaDTO dto, String id) {
        Pasta pasta = repository.findById(id)
                .orElseThrow();

        pasta.setNome(dto.getNome());
        pasta.setOrdem(dto.getOrdem());
        LocalDateTime now = LocalDateTime.now();
        pasta.setUltima_alteracao(now);

        return pasta;
    }
}
