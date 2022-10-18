package com.gymstarter.gymstarterapp.controllers;

import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import com.gymstarter.gymstarterapp.services.AlunoService;
import com.gymstarter.gymstarterapp.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Autowired
    private FotoService fotoService;

    @PostMapping
    public ResponseEntity cadastraAluno(@RequestParam("foto") MultipartFile foto, @RequestParam("form") String form) throws IOException {

        FormAluno formAluno = this.service.serializeFormAluno(form);
        String url = fotoService.save(foto,formAluno);
        service.save(formAluno,url);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

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
