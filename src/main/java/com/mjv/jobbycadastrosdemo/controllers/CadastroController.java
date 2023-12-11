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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CadastroController {

    // DI da Service Pattern
    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping("/cadastros")
    public ResponseEntity<List<CadastroModel>> getAllCadastros() {
        List<CadastroModel> cadastroModels = cadastroService.listAll();
        return cadastroModels.isEmpty()
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.OK).body(cadastroModels);
    }

    @GetMapping("/cadastros/{id}")
    public ResponseEntity<Object> getOneCadastroById(@PathVariable(value = "id") UUID id) {
        CadastroModel cadastroModel = cadastroService.findById(id);
        return cadastroModel != null
                ? ResponseEntity.status(HttpStatus.OK).body(cadastroModel)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/cadastros")
    public ResponseEntity<CadastroModel> saveCadastro(@RequestBody @Valid CadastroRecordDto cadastroRecordDto) {
        cadastroService.save(cadastroRecordDto);
        return ResponseEntity.status((HttpStatus.CREATED)).build();
    }

    @PutMapping("/cadastros/{id}")
    public ResponseEntity<Object> updateCadastro(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid CadastroRecordDto cadastroRecordDto) {
        CadastroModel cadastroModel = cadastroService.findById(id);
        return cadastroModel != null
                ? ResponseEntity.status(HttpStatus.OK).body(cadastroService.update(id, cadastroRecordDto))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/cadastros/{id}")
    public ResponseEntity<Object> deleteCadastro(@PathVariable(value = "id") UUID id) {
        if (id == null || id.toString() == "")
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com exito!");
    }
}
