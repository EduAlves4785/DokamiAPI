package io.github.edualves4785.dokamiapi.application.categorias;

import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.service.CategoriaService;
import io.github.edualves4785.dokamiapi.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/categorias")
@Slf4j
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;
    private final CategoriaMapper categoriaMapper;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CategoriaDTO dto){
        try {
            Categoria categoria=categoriaMapper.mapToCategoria(dto);
            service.cadastrarCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            Map<String, String> jsonResultado= Map.of("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> buscarCategoria(){

        var result=service.findAll();

        var categorias=result.stream().map(categoria -> {
            return categoriaMapper.categoriaToDTO(categoria);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizar(
            @PathVariable String id,
            @RequestBody CategoriaDTO dto) {

        Categoria categoria = service.atualizar(dto, id);

        var result=categoriaMapper.categoriaToDTO(categoria);

        return ResponseEntity.ok(result);
    }

}
