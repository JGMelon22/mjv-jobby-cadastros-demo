package com.mjv.jobbycadastrosdemo.api.dto;

import com.mjv.jobbycadastrosdemo.domain.model.enums.SexoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroPutRecordDto(@NotNull UUID idCadastro, @NotBlank String nome, @NotBlank String cpf,
                                   @NotNull LocalDate dataNascimento,
                                   @NotNull SexoEnum sexo, @NotBlank String logradouro,
                                   @NotNull Integer numero, @NotBlank String bairro, @NotBlank String complemento,
                                   @NotBlank String cidade, @NotBlank String estado,
                                   @NotBlank @Email String email, @NotNull Long telefone, Long celular,
                                   @NotNull boolean celularWhats, @NotBlank String profissao,
                                   @NotBlank String empresa, @NotNull Double salario, @NotNull boolean empregoAtual,
                                   @NotNull BigDecimal pretencaoMinima,
                                   @NotNull BigDecimal pretencaoMaxima, @NotBlank String habilidades) {
}
