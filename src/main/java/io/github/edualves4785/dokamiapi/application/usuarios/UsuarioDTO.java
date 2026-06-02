package io.github.edualves4785.dokamiapi.application.usuarios;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
}
