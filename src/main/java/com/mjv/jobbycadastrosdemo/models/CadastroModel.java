package com.mjv.jobbycadastrosdemo.models;

import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "cadastros", indexes = @Index(columnList = "idCadastro"))
public class CadastroModel implements Serializable {


    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private

}
