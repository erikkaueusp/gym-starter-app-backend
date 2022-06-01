package com.gymstarter.gymstarterapp.controllers;

import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import com.gymstarter.gymstarterapp.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;


    @GetMapping
    private ResponseEntity<AlunoModel> findAlunoByName(@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findByName(nome));
    }

    @PutMapping
    private ResponseEntity updateAluno(AlunoModel model) {
        this.service.updateAluno(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    private ResponseEntity removerAluno(String nome) {
        this.service.removeAlunoByName(nome);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
