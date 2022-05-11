package com.gymstarter.gymstarterapp;

import com.gymstarter.gymstarterapp.entity.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FormAluno implements Serializable {

    private String nome;

    private String email;

    private String endereco;

    private String tel;


    public Aluno converterToAluno(String url) {
        Aluno aluno = new Aluno();
        aluno.setNome(this.getNome());
        aluno.setEmail(this.getEmail());
        aluno.setEndereco(this.getEndereco());
        aluno.setTelefone(this.getTel());
        aluno.setCaminhoFoto(url);
        return aluno;
    }


}
