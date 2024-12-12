package com.api.Catalogo.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeEntity, Integer> {

    FilmeEntity findByTitulo(String titulo);

    List<FilmeEntity> findByGenero(String genero);

    List<FilmeEntity> findByOrderByTituloAsc();
    
    List<FilmeEntity> findByOrderByTituloDesc();
    
    List<FilmeEntity> findByTituloContaining(String titulo);
    
    List<FilmeEntity> findByOrderByAnoLancamentoAsc();
    
    List<FilmeEntity> findByOrderByAnoLancamentoDesc();
}