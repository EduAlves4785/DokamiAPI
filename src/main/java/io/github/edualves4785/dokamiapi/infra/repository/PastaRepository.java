package io.github.edualves4785.dokamiapi.infra.repository;

import io.github.edualves4785.dokamiapi.domain.entities.Categoria;
import io.github.edualves4785.dokamiapi.domain.entities.Pasta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastaRepository extends JpaRepository<Pasta, String> {
}
