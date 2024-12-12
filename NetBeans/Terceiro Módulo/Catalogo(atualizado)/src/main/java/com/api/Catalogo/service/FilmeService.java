package com.api.Catalogo.service;

import com.api.Catalogo.data.FilmeEntity;
import com.api.Catalogo.data.FilmeRepository;
import com.api.Catalogo.exception.ResourceNotFoundException;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import java.util.Optional;

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

    public boolean deletarFilme(Integer id) {
        Optional<FilmeEntity> filme = FilmeRepository.findById(id);
        if (filme.isPresent()) {
            FilmeRepository.delete(filme.get());
            return true;
        }
        return false;
    }
    
    public List<FilmeEntity> getFilmePorTitulo(String titulo) { 
        return FilmeRepository.findByTituloContaining(titulo); 
    }
}