package com.gymstarter.gymstarterapp.entity.aluno;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String email;

    private String endereco;

    private String telefone;

    @Column(columnDefinition="TEXT", length = 3000000)
    private String base;

    private LocalDateTime dataCriacao = LocalDateTime.now();


}
