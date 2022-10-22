package com.gymstarter.gymstarterapp.services;

import com.google.gson.Gson;
import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.entity.aluno.Aluno;
import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import com.gymstarter.gymstarterapp.exceptions.EntityNotFound;
import com.gymstarter.gymstarterapp.exceptions.ExistUserException;
import com.gymstarter.gymstarterapp.repository.AlunoDTO;
import com.gymstarter.gymstarterapp.repository.AlunoRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;


    public FormAluno serializeFormAluno(String form) {
        Gson gson = new Gson();
        FormAluno formAluno = gson.fromJson(form, FormAluno.class);
        return formAluno;
    }

    public void save(FormAluno formAluno, String base) {
        if(!this.findAlunosModel(formAluno.getNome()).isEmpty()){
            throw new ExistUserException("Já existe aluno cadastrado.");
        }
        Aluno aluno = formAluno.converterToAluno(base);
        repository.save(aluno);
    }
    public List<AlunoDTO> findAlunosModel(String nome) {
        if(nome == null) {
            return this.repository.findAlunosModel();
        }
        return this.repository.findAlunosModel(nome);
    }

    public void updateAluno(AlunoModel model) {

        if (model.getId()!= null) {
            Aluno aluno = this.repository.getById(model.getId());
            aluno.setNome(model.getNome());
            aluno.setEmail(model.getEmail());
            aluno.setEndereco(model.getEndereco());
            aluno.setTelefone(model.getTelefone());
            aluno.setBase(model.getBase());
            this.repository.save(aluno);
        } else {
            throw new EntityNotFound("Aluno não encontrado");
        }
    }

    public void removeAlunoByName(String nome) {
        Aluno aluno = this.repository.findByNome(nome);
        if (Objects.isNull(aluno)) {
            throw new EntityNotFound("Aluno não encontrado");
        } else {
            this.repository.delete(aluno);
        }
    }
}
