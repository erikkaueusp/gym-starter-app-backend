package com.gymstarter.gymstarterapp.services;

import com.google.gson.Gson;
import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.entity.aluno.Aluno;
import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import com.gymstarter.gymstarterapp.exceptions.EntityNotFound;
import com.gymstarter.gymstarterapp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void save(FormAluno formAluno, String url) {
        //TODO velidação para cadastro com nomes iguais.
        Aluno aluno = formAluno.converterToAluno(url);
        repository.save(aluno);
    }
    public AlunoModel findByName(String name) {
        Aluno aluno = this.repository.findByNome(name);
        if (Objects.isNull(aluno)) {
            throw new EntityNotFound("Aluno não encontrado");
        } else {
            AlunoModel model = new AlunoModel();

            model.setId(aluno.getId());
            model.setNome(aluno.getNome());
            model.setEmail(aluno.getEmail());
            model.setTelefone(aluno.getTelefone());
            model.setEndereco(aluno.getEndereco());
            model.setImagem(aluno.getCaminhoFoto());
            return model;
        }
    }

    public void updateAluno(AlunoModel model) {

        if (model.getId()!= null) {
            Aluno aluno = this.repository.getById(model.getId());
            aluno.setNome(model.getNome());
            aluno.setEmail(model.getEmail());
            aluno.setEndereco(model.getEndereco());
            aluno.setTelefone(model.getTelefone());
            aluno.setCaminhoFoto(model.getImagem());
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
