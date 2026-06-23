package io.github.edualves4785.dokamiapi.infra.repository;

import io.github.edualves4785.dokamiapi.domain.entities.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConteudoRepository extends JpaRepository<Conteudo, String> {
    List<Conteudo> findByPasta_Id(String idPasta);
}
