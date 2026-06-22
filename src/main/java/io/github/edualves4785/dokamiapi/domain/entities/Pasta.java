package io.github.edualves4785.dokamiapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pasta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @Column
    private String nome;

    @Column
    private int ordem;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Column
    @CreatedDate
    private LocalDateTime data_criacao;
    @Column
    @LastModifiedDate
    private LocalDateTime ultima_alteracao;

}
