package com.gymstarter.gymstarterapp.entity.aluno.model;

import com.gymstarter.gymstarterapp.repository.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlunoModel implements AlunoDTO {

    private Long id;

    private String nome;

    private String email;

    private String endereco;

    private String telefone;

    private String base;
}