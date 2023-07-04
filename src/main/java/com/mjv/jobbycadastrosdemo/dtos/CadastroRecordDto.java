package com.mjv.jobbycadastrosdemo.dtos;

import com.mjv.jobbycadastrosdemo.enums.SexoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroRecordDto(@NotBlank String nome, @NotBlank String cpf, @NotBlank LocalDate dataNascimento,
                                @NotBlank SexoEnum sexo, @NotBlank String logradouro,
                                @NotNull Integer numero, @NotBlank String bairro, @NotBlank String complemento,
                                @NotBlank String cidade, @NotBlank String estado,
                                @NotBlank @Email String email, @NotNull Long telefone, Long celular,
                                @NotBlank boolean celularWhats, @NotBlank String profissao,
                                @NotBlank String empresa, @NotNull Double salario, @NotBlank boolean empregoAtual,
                                @NotNull BigDecimal pretencaoMinima,
                                @NotNull BigDecimal pretencaoMaxima, @NotBlank String habilidades) {
}
