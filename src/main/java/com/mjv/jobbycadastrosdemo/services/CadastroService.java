package com.mjv.jobbycadastrosdemo.services;

import com.mjv.jobbycadastrosdemo.dtos.CadastroRecordDto;
import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public List<CadastroModel> listAll() {
        return cadastroRepository.findAll();
    }

    public CadastroModel findById(UUID id) {
        Optional<CadastroModel> cadastroModel0 = cadastroRepository.findById(id);
        if (cadastroModel0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado!");
        return cadastroModel0.get();
    }

    public void save(CadastroRecordDto cadastroRecordDto) {
        CadastroModel cadastroModel0 = new CadastroModel();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel0);

        cadastroRepository.save(cadastroModel0);
    }

    public CadastroModel update(UUID id, CadastroRecordDto cadastroRecordDto) {
        Optional<CadastroModel> cadastroModel0 = cadastroRepository.findById(id);
        if (cadastroModel0.isPresent())
            cadastroModel0.get();

        CadastroModel cadastroModel = cadastroModel0.get();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel);

        return cadastroRepository.save(cadastroModel);
    }

    public void delete(UUID id) {
        Optional<CadastroModel> cadastroModel0 = cadastroRepository.findById(id);
        if (cadastroModel0.isPresent())
            cadastroRepository.delete(cadastroModel0.get());
    }
}
