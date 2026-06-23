package io.github.edualves4785.dokamiapi.domain.entities;

import io.github.edualves4785.dokamiapi.domain.enums.TipoConteudo;
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
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="pasta_id")
    private Pasta pasta;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoConteudo tipo;
    @Column
    private String conteudo_texto;
    @Column
    private String url;
    @Column
    private String caminho_arquivo;
    @Column
    private String extensao_arquivo;
    @Column
    private String tamanho_arquivo;
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
