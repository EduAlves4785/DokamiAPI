package io.github.edualves4785.dokamiapi.application.usuarios;

import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.github.edualves4785.dokamiapi.domain.entities.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuarios")
@Slf4j
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastrar(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha
    ){
        log.info("Usuário recebido: nome: {}, email: {}",nome, email);
        Usuario u=Usuario
                .builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .build();
        usuarioService.cadastrar(u);
        return ResponseEntity.ok().build();
    }
}
