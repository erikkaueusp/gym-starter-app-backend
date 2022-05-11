package com.gymstarter.gymstarterapp.services;

import com.google.gson.Gson;
import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.entity.Aluno;
import com.gymstarter.gymstarterapp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;


    public FormAluno serializeFormAluno(String form) {
        Gson gson = new Gson();
        FormAluno formAluno = gson.fromJson(form, FormAluno.class);
        return formAluno;
    }

    public void save(FormAluno formAluno, String url) {
        //TODO velidação para cadastro com nomes iguais.
        Aluno aluno = formAluno.converterToAluno(url);
        repository.save(aluno);



    }

}
