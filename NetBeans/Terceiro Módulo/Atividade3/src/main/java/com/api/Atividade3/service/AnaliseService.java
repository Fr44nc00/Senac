package com.api.Atividade3.service;

import com.api.Atividade3.data.AnaliseEntity;
import com.api.Atividade3.data.AnaliseRepository;
import com.api.Atividade3.data.FilmeEntity;
import com.api.Atividade3.exception.ResourceNotFoundException;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import java.util.Optional;

@Service 
public class AnaliseService { 
    @Autowired 
    AnaliseRepository AnaliseRepository; 

    public AnaliseEntity informarAnalise(AnaliseEntity analise) { 
        analise.setId(null);
        AnaliseRepository.save(analise);
        
        return analise;
    } 

    @Autowired
    private FilmeService filmeService;

    public AnaliseEntity atualizarAnalise(Integer analiseId, AnaliseEntity analiseRequest) {
        AnaliseEntity analise = getAnaliseId(analiseId);

        FilmeEntity filme = filmeService.getFilmeId(analiseRequest.getFilme().getId());
        if (filme == null) {
            throw new ResourceNotFoundException("Filme não encontrado com ID: "
                    + analiseRequest.getFilme().getId());
        }

        analise.setFilme(filme);
        analise.setDetalhes(analiseRequest.getDetalhes());
        analise.setNota(analiseRequest.getNota());

        return AnaliseRepository.save(analise);
    }

    public AnaliseEntity getAnaliseId(Integer analiseId) { 
        return AnaliseRepository.findById(analiseId).orElseThrow(() ->
                new ResourceNotFoundException("Analise não encontrada " + analiseId));                
    }  

    public List<AnaliseEntity> listarAnalisesPorFilme(Integer idFilme) {
        return AnaliseRepository.findByFilmeId(idFilme);
    } 

    public boolean deletarAnalise(Integer analiseId) {
        Optional<AnaliseEntity> analise = AnaliseRepository.findById(analiseId);
        if (analise.isPresent()) {
            AnaliseRepository.delete(analise.get());
            return true;
        }
        return false;
    }
}