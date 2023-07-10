package com.mjv.jobbycadastrosdemo.controllers;

import com.mjv.jobbycadastrosdemo.dtos.CadastroPutRecordDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/cadastros/{id}")
    public ResponseEntity<Object> getOneCadastro(@PathVariable(value = "id") UUID id) {
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if (cadastro0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cadastro0.get());
    }

    @PutMapping("/cadastros/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid CadastroPutRecordDto cadastroPutRecordDto) {
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if (cadastro0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
        }

        var cadastroModel = cadastro0.get();
        BeanUtils.copyProperties(cadastroPutRecordDto, cadastroModel);
        return ResponseEntity.status(HttpStatus.OK).body(cadastroRepository.save(cadastroModel));
    }

    @DeleteMapping("/cadastros/{id}")
    public ResponseEntity<Object> deleteCadastro(@PathVariable(value = "id") UUID id) {
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if (cadastro0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
        }

        cadastroRepository.delete(cadastro0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com exito!");
    }

    // Usando service pattern
    // @DeleteMapping("/cadastros/{id}")
    // public ResponseEntity<Void> deleteCadastro(@PathVariable UUID id) {
    //     cadastroService.delete(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // Usando service pattern
    // @GetMapping("/cadastros/{id}")
    // public ResponseEntity<Object> getOneCadastro(@PathVariable(value = "id") UUID id) {
    //     return new ResponseEntity<>(cadastroService.findById(id), HttpStatus.OK);
    // }

}
