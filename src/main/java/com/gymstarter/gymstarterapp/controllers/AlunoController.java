package com.gymstarter.gymstarterapp.controllers;

import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import com.gymstarter.gymstarterapp.repository.AlunoDTO;
import com.gymstarter.gymstarterapp.services.AlunoService;
import com.gymstarter.gymstarterapp.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Autowired
    private FotoService fotoService;

    @PostMapping
    public ResponseEntity cadastraAluno(@RequestBody FormAluno aluno) {
        service.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    private List<AlunoDTO> findAlunos(@RequestParam(required = false) String nome) {
        List<AlunoDTO> alunos = service.findAlunosModel(nome);
        return alunos;
    }

    @PutMapping
    private ResponseEntity updateAluno(@RequestBody FormAluno aluno) {
        this.service.updateAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    private ResponseEntity removerAluno(@RequestParam String nome) {
        this.service.removeAlunoByName(nome);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
