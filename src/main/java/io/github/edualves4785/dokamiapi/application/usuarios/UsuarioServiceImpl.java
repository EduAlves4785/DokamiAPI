package io.github.edualves4785.dokamiapi.application.usuarios;

import io.github.edualves4785.dokamiapi.jwt.JwtService;
import io.github.edualves4785.dokamiapi.domain.entities.AccessToken;
import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.github.edualves4785.dokamiapi.domain.exception.TuplaDuplicadaExcpetion;
import io.github.edualves4785.dokamiapi.domain.service.UsuarioService;
import io.github.edualves4785.dokamiapi.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Usuario getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Usuario getUsuarioLogado() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        return (Usuario) auth.getPrincipal();
    }

    @Override
    @Transactional
    public Usuario cadastrar(Usuario usuario) {
        var possivelUsuario=getByEmail(usuario.getEmail());
        if (possivelUsuario!=null){
            throw new TuplaDuplicadaExcpetion("Usuário já existe!");
        }
        encodePassword(usuario);
        return repository.save(usuario);
    }

    @Override
    public AccessToken autenticar(String email, String senha) {
        var user = getByEmail(email);
        if (user==null){
            return null;
        }
        boolean validaSenha=passwordEncoder.matches(senha, user.getSenha());
        if (validaSenha){
            return jwtService.gerarToken(user);
        }

        return null;
    }

    private void encodePassword(Usuario usuario){
        String rawPassword=usuario.getSenha();
        String encodedPassword=passwordEncoder.encode(rawPassword);
        usuario.setSenha(encodedPassword);
    }
}
