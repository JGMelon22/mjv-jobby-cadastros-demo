package com.mjv.jobbycadastrosdemo.controllers;

import com.mjv.jobbycadastrosdemo.dtos.CadastroRecordDto;
import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import com.mjv.jobbycadastrosdemo.services.CadastroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;

    // DI da Service Pattern
    private final CadastroService cadastroService;

    @PostMapping("/cadastros")
    public ResponseEntity<CadastroModel> saveCadastro(@RequestBody @Valid CadastroRecordDto cadastroRecordDto) {
        CadastroModel cadastroModel = new CadastroModel();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel); // Converte dto para model
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroRepository.save(cadastroModel));
    }

    // Aqui já utilizei a service pattern do Java
    @GetMapping("/cadastros")
    public ResponseEntity<List<CadastroModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(cadastroService.listAll());
    }
}
