package com.api.senac.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {

    FuncionarioEntity findByNome(String nome);

    List<FuncionarioEntity> findByNomeOrEmail(String nome, String email);

    List<FuncionarioEntity> findByNomeStartingWith(String nome);

    List<FuncionarioEntity> findByNomeEndingWith(String nome);

    List<FuncionarioEntity> findByNomeContaining(String nome);

    List<FuncionarioEntity> findByOrderByNomeAsc();

    List<FuncionarioEntity> findByOrderByNomeDesc();
}