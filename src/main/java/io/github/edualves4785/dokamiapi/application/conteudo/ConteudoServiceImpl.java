package io.github.edualves4785.dokamiapi.application.conteudo;

import io.github.edualves4785.dokamiapi.domain.entities.Conteudo;
import io.github.edualves4785.dokamiapi.domain.enums.TipoConteudo;
import io.github.edualves4785.dokamiapi.domain.service.ConteudoService;
import io.github.edualves4785.dokamiapi.domain.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.ConteudoRepository;
import io.github.edualves4785.dokamiapi.infra.repository.PastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConteudoServiceImpl implements ConteudoService {

    private final ConteudoRepository repository;
    private final PastaRepository pastaRepository;
    private final UsuarioService usuarioService;
    private final ConteudoMapper mapper;

    @Override
    @Transactional
    public void cadastrarConteudo(ConteudoDTO dto) {
        Conteudo conteudo=mapper.mapToConteudo(dto);
        conteudo.setPasta(pastaRepository.getById(dto.getIdPasta()));
        conteudo.setUsuario(usuarioService.getUsuarioLogado());
        repository.save(conteudo);
    }

    @Override
    public List<Conteudo> findByPasta_Id(String idPasta) {
        return repository.findByPasta_Id(idPasta);
    }
}
