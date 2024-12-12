package com.api.Atividade2.service;

import com.api.Atividade2.data.AnaliseEntity; 
import com.api.Atividade2.data.AnaliseRepository;
import com.api.Atividade2.exception.ResourceNotFoundException;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service 
public class AnaliseService { 
    @Autowired 
    AnaliseRepository AnaliseRepository; 

    public AnaliseEntity informarAnalise(AnaliseEntity analise) { 
        analise.setId(null);
        AnaliseRepository.save(analise);
        
        return analise;
    } 

    public AnaliseEntity atualizarAnalise(Integer analiseId,
            AnaliseEntity AnaliseRequest) { 

        AnaliseEntity Analise = getAnaliseId(analiseId); 
        Analise.setFilme(AnaliseRequest.getFilme());
        Analise.setDetalhes(AnaliseRequest.getDetalhes()); 
        Analise.setNota(AnaliseRequest.getNota()); 
        AnaliseRepository.save(Analise); 

        return Analise; 
    } 

    public AnaliseEntity getAnaliseId(Integer analiseId) { 
        return AnaliseRepository.findById(analiseId).orElseThrow(() ->
                new ResourceNotFoundException("Analise não encontrada " + analiseId));                
    }  

    public List<AnaliseEntity> listarAnalisesPorFilme(Integer idFilme) {
        return AnaliseRepository.findByFilmeId(idFilme);
    } 

    public void deletarAnalise(Integer analiseId) { 
        AnaliseEntity Analise = getAnaliseId(analiseId); 
        AnaliseRepository.deleteById(Analise.getId()); 
    }
}