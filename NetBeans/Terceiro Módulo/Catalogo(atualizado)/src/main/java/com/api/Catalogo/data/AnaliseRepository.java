package com.api.Catalogo.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Integer> {
    
    List<AnaliseEntity> findByFilmeId(Integer filmeId);

}