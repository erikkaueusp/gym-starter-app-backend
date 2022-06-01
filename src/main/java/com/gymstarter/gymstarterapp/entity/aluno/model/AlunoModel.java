package com.gymstarter.gymstarterapp.entity.aluno.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoModel {

    private Long id;

    private String nome;

    private String email;

    private String endereco;

    private String telefone;

    private String imagem;
}
