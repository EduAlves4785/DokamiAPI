package io.github.edualves4785.dokamiapi.application.usuarios;

import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.github.edualves4785.dokamiapi.domain.exception.TuplaDuplicadaExcpetion;
import io.github.edualves4785.dokamiapi.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/usuarios")
@Slf4j
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody UsuarioDTO dto){
        try {
            Usuario usuario= usuarioMapper.mapToUsuario(dto);
            usuarioService.cadastrar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (TuplaDuplicadaExcpetion e){
            Map<String, String> jsonResultado= Map.of("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @PostMapping("/auth")
    public ResponseEntity autenticar(@RequestBody CredenciaisDTO credenciais){
        var token=usuarioService.autenticar(credenciais.getEmail(), credenciais.getSenha());
        if (token==null){
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(token);
    }
}
