package com.api.Atividade2.service;

import com.api.Atividade2.data.FilmeEntity; 
import com.api.Atividade2.data.FilmeRepository;
import com.api.Atividade2.exception.ResourceNotFoundException;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service 
public class FilmeService { 
    @Autowired 
    FilmeRepository FilmeRepository; 

    public FilmeEntity informarFilme(FilmeEntity filme) { 
        filme.setId(null);
        FilmeRepository.save(filme);
        
        return filme;
    } 

    public FilmeEntity atualizarFilme(Integer filmeId, FilmeEntity FilmeRequest) { 

        FilmeEntity filme = getFilmeId(filmeId); 
        filme.setTitulo(FilmeRequest.getTitulo()); 
        filme.setSinopse(FilmeRequest.getSinopse()); 
        filme.setGenero(FilmeRequest.getGenero());
        filme.setAnoLancamento(FilmeRequest.getAnoLancamento()); 
        FilmeRepository.save(filme); 

        return filme; 
    } 

    public FilmeEntity getFilmeId(Integer filmeId) { 
        return FilmeRepository.findById(filmeId).orElseThrow(() ->
                new ResourceNotFoundException("Filme não encontrado " + filmeId));                
    }  

    public List<FilmeEntity> listarTodosFilmes() { 
        return FilmeRepository.findAll(); 
    } 

    public void deletarFilme(Integer filmeId) { 
        FilmeEntity filme = getFilmeId(filmeId); 
        FilmeRepository.deleteById(filme.getId()); 
    }
    
    public List<FilmeEntity> getFilmePorTitulo(String titulo) { 
        return FilmeRepository.findByTituloContaining(titulo); 
    }
}