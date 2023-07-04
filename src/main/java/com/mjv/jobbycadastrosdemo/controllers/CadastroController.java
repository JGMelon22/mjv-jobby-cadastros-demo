package com.mjv.jobbycadastrosdemo.controllers;

import com.mjv.jobbycadastrosdemo.repositories.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;
}
