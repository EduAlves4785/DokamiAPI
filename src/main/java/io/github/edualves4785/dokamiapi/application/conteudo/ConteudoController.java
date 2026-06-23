package io.github.edualves4785.dokamiapi.application.conteudo;

import io.github.edualves4785.dokamiapi.application.categorias.CategoriaDTO;
import io.github.edualves4785.dokamiapi.application.categorias.CategoriaResponseDTO;
import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Conteudo;
import io.github.edualves4785.dokamiapi.domain.service.ConteudoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/conteudos")
@Slf4j
@RequiredArgsConstructor
public class ConteudoController {

    private final ConteudoService service;
    private final ConteudoMapper mapper;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ConteudoDTO dto){
        try {
            service.cadastrarConteudo(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            Map<String, String> jsonResultado= Map.of("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ConteudoResponseDTO>> buscarConteudoPasta( @PathVariable String id){

        var result=service.findByPasta_Id(id);

        var conteudos=result.stream().map(conteudo -> {
            return mapper.conteudoToDTO(conteudo);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(conteudos);
    }

}
