package com.mjv.jobbycadastrosdemo.models;

import com.mjv.jobbycadastrosdemo.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cadastros", indexes = @Index(name = "cadastro_id_index", columnList = "cadastro_id"))
public class CadastroModel implements Serializable {

    private static final long SERIALVERSIONUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cadastro_id")
    @Getter
    @Setter
    private UUID idCadastro;

    @Column(name = "nome", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false)
    @Getter
    @Setter
    private String cpf;

    @Column(name = "data_nascimento", columnDefinition = "DATE", nullable = false)
    @Getter
    @Setter
    private LocalDate dataNascimento;

    @Column(name = "sexo", columnDefinition = "CHAR(1)", nullable = false)
    @Getter
    @Setter
    private SexoEnum sexo;

    @Column(name = "logradouro", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String logradouro;

    @Column(name = "numero", columnDefinition = "INTEGER", nullable = true)
    @Getter
    @Setter
    private Integer numero;

    @Column(name = "bairro", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String bairro;

    @Column(name = "complemento", columnDefinition = "VARCHAR(100)", nullable = true)
    @Getter
    @Setter
    private String complemento;

    @Column(name = "cidade", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "estado", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String estado;

    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name = "telefone", columnDefinition = "BIGINT", nullable = false)
    @Getter
    @Setter
    private Long telefone;

    @Column(name = "celular", columnDefinition = "BIGINT", nullable = false)
    @Getter
    @Setter
    private Long celular;

    @Column(name = "celular_whats", columnDefinition = "BOOLEAN default false")
    @Getter
    @Setter
    private boolean celularWhats;

    @Column(name = "profissao", columnDefinition = "VARCHAR(100)", nullable = true)
    @Getter
    @Setter
    private String profissao;

    @Column(name = "empresa", columnDefinition = "VARCHAR(100)", nullable = true)
    @Getter
    @Setter
    private String empresa;

    @Column(name = "salario", columnDefinition = "DOUBLE", nullable = true)
    @Getter
    @Setter
    private Double salario;

    @Column(name = "emprego_atual", columnDefinition = "BOOLEAN default false")
    @Getter
    @Setter
    private boolean empregoAtual;

    @Column(name = "pretencao_minima", columnDefinition = "REAL", nullable = false)
    @Getter
    @Setter
    private BigDecimal pretencaoMinima;

    @Column(name = "pretencao_maxima", columnDefinition = "REAL", nullable = false)
    @Getter
    @Setter
    private BigDecimal pretencaoMaxima;

    @Column(name = "habilidades", columnDefinition = "VARCHAR(255)", nullable = false)
    @Getter
    @Setter
    private String habilidades;
}
