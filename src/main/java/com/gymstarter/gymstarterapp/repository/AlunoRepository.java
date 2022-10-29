package com.gymstarter.gymstarterapp.repository;

import com.gymstarter.gymstarterapp.entity.aluno.Aluno;
import com.gymstarter.gymstarterapp.entity.aluno.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findBynomeIgnoreCase(String nome);

    Aluno findByNome(String nome);

    @Query(value = "SELECT a.id as id, a.nome as nome, a.email as email, a.endereco as endereco, a.telefone as telefone, a.base as base from Aluno a")
    List<AlunoDTO> findAlunosModel();

    @Query(value = "SELECT a.id as id, a.nome as nome, a.email as email, a.endereco as endereco, a.telefone as telefone, a.base as base from Aluno a where a.nome=:nome")
    List<AlunoDTO> findAlunosModel(String nome);

}
