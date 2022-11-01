package com.gymstarter.gymstarterapp;

import com.gymstarter.gymstarterapp.entity.aluno.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FormAluno implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String endereco;

    private String telefone;

    private String base;


    public Aluno converterToAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.getNome());
        aluno.setEmail(this.getEmail());
        aluno.setEndereco(this.getEndereco());
        aluno.setTelefone(this.getTelefone());
        aluno.setBase(this.getBase());
        return aluno;
    }


}
