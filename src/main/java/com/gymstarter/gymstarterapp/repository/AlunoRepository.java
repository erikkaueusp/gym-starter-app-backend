package com.gymstarter.gymstarterapp.repository;

import com.gymstarter.gymstarterapp.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findBynomeIgnoreCase(String nome);

    Aluno findByNome(String nome);

}
