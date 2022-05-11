package com.gymstarter.gymstarterapp.controllers;

import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.services.AlunoService;
import com.gymstarter.gymstarterapp.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity cadastraForm(@RequestParam("foto") MultipartFile foto, @RequestParam("form") String form) throws IOException {

        FormAluno formAluno = this.alunoService.serializeFormAluno(form);
        String url = fotoService.save(foto,formAluno);
        alunoService.save(formAluno,url);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
