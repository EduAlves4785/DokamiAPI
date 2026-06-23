package io.github.edualves4785.dokamiapi.application.pastas;

import io.github.edualves4785.dokamiapi.domain.entities.Pasta;
import io.github.edualves4785.dokamiapi.domain.service.PastaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/pastas")
@Slf4j
@RequiredArgsConstructor
public class PastaController {

    private final PastaService service;
    private final PastaMapper mapper;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody PastaDTO dto){
        try {
            service.criarPasta(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            Map<String, String> jsonResultado= Map.of("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping
    public ResponseEntity<List<PastaResponseDTO>> buscarCategoria(){

        var result=service.findAll();

        var pastas=result.stream().map(pasta -> {
            return mapper.pastaToDTO(pasta);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(pastas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PastaResponseDTO> atualizar(
            @PathVariable String id,
            @RequestBody PastaDTO dto) {

        Pasta pasta = service.atualizar(dto, id);

        var result=mapper.pastaToDTO(pasta);

        return ResponseEntity.ok(result);
    }
}
