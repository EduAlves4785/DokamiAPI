package io.github.edualves4785.dokamiapi.application.usuarios;

import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.github.edualves4785.dokamiapi.domain.entities.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    @Transactional
    public Usuario cadastrar(Usuario u) {
        return repository.save(u);
    }
}
