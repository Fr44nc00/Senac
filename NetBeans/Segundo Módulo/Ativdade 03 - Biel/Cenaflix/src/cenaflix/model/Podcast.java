package cenaflix.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Podcast implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produtor;
    private String nomeEpisodio;
    private int numeroEpisodio;
    private int duracao;
    private String url;

    // Construtor, getters e setters
}
