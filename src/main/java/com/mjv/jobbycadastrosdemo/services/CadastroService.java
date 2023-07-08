package com.mjv.jobbycadastrosdemo.services;

import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public List<CadastroModel> listAll() {
        return cadastroRepository.findAll();
    }

    public CadastroModel findById(UUID id) {
        return cadastroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado!"));
    }

    // TODO - post and edit
    public void delete(UUID id) {
        cadastroRepository.delete(findById(id));
    }
}
