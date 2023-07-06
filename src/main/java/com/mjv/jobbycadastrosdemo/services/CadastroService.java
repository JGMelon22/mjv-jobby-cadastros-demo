package com.mjv.jobbycadastrosdemo.services;

import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public List<CadastroModel> listAll() {
        return cadastroRepository.findAll();
    }
}
