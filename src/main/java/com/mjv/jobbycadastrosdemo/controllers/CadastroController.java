package com.mjv.jobbycadastrosdemo.controllers;

import com.mjv.jobbycadastrosdemo.dtos.CadastroRecordDto;
import com.mjv.jobbycadastrosdemo.models.CadastroModel;
import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;

    @PostMapping("/cadastros")
    public ResponseEntity<CadastroModel> saveCadastro(@RequestBody @Valid CadastroRecordDto cadastroRecordDto) {
        CadastroModel cadastroModel = new CadastroModel();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroRepository.save(cadastroModel));
    }
}
