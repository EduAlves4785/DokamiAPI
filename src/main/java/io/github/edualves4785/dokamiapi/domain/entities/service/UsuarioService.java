package io.github.edualves4785.dokamiapi.domain.entities.service;

import io.github.edualves4785.dokamiapi.domain.entities.AccessToken;
import io.github.edualves4785.dokamiapi.domain.entities.Usuario;

public interface UsuarioService {
    Usuario cadastrar(Usuario usuario);
    Usuario getByEmail(String email);
    AccessToken autenticar(String email, String password);
}
