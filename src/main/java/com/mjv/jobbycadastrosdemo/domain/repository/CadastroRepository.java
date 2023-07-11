package com.mjv.jobbycadastrosdemo.domain.repository;

import com.mjv.jobbycadastrosdemo.domain.model.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, UUID> {

}
