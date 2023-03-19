package com.arthur.controle.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.controle.enums.NivelEnum;
import com.arthur.controle.models.PessoaModel;
import com.arthur.controle.repositories.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }
    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> findById(UUID id) {
        return pessoaRepository.findById(id);
    }

    public List<PessoaModel> findAllByNivel(NivelEnum nivel) {
        return pessoaRepository.findAllByNivel(nivel);
    }
}
