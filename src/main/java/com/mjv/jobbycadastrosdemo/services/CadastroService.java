package com.mjv.jobbycadastrosdemo.services;

import com.mjv.jobbycadastrosdemo.dtos.CadastroPutRecordDto;
import com.mjv.jobbycadastrosdemo.dtos.CadastroRecordDto;
import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

    // TODO - post, edit and delete
    public void delete(UUID id) {
        cadastroRepository.delete(findById(id));
    }
}
