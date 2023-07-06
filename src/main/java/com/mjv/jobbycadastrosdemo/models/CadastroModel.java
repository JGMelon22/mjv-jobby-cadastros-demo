package com.mjv.jobbycadastrosdemo.models;

import com.mjv.jobbycadastrosdemo.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity // 1h4min
@Getter
@Setter
@Table(name = "cadastros", indexes = @Index(name = "cadastro_id_index", columnList = "cadastro_id"))
public class CadastroModel implements Serializable {

    private static final long SERIALVERSIONUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cadastro_id")

    private UUID idCadastro;

    @Column(name = "nome", columnDefinition = "VARCHAR(100)", nullable = false)

    private String nome;

    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false)

    private String cpf;

    @Column(name = "data_nascimento", columnDefinition = "DATE", nullable = false)

    private LocalDate dataNascimento;

    @Column(name = "sexo", columnDefinition = "CHAR(9)", nullable = false)
    @Enumerated(EnumType.STRING)

    private SexoEnum sexo;

    @Column(name = "logradouro", columnDefinition = "VARCHAR(100)", nullable = false)

    private String logradouro;

    @Column(name = "numero", columnDefinition = "INTEGER", nullable = true)

    private Integer numero;

    @Column(name = "bairro", columnDefinition = "VARCHAR(100)", nullable = false)

    private String bairro;

    @Column(name = "complemento", columnDefinition = "VARCHAR(100)", nullable = true)

    private String complemento;

    @Column(name = "cidade", columnDefinition = "VARCHAR(100)", nullable = false)

    private String cidade;

    @Column(name = "estado", columnDefinition = "VARCHAR(100)", nullable = false)

    private String estado;

    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)

    private String email;

    @Column(name = "telefone", columnDefinition = "BIGINT", nullable = false)

    private Long telefone;

    @Column(name = "celular", columnDefinition = "BIGINT", nullable = false)

    private Long celular;

    @Column(name = "celular_whats", columnDefinition = "BOOLEAN default false")

    private boolean celularWhats;

    @Column(name = "profissao", columnDefinition = "VARCHAR(100)", nullable = true)

    private String profissao;

    @Column(name = "empresa", columnDefinition = "VARCHAR(100)", nullable = true)

    private String empresa;

    @Column(name = "salario", columnDefinition = "DOUBLE PRECISION", nullable = true)

    private Double salario;

    @Column(name = "emprego_atual", columnDefinition = "BOOLEAN default false")

    private boolean empregoAtual;

    @Column(name = "pretencao_minima", columnDefinition = "REAL", nullable = false)

    private BigDecimal pretencaoMinima;

    @Column(name = "pretencao_maxima", columnDefinition = "REAL", nullable = false)

    private BigDecimal pretencaoMaxima;

    @Column(name = "habilidades", columnDefinition = "VARCHAR(255)", nullable = false)

    private String habilidades;
}
