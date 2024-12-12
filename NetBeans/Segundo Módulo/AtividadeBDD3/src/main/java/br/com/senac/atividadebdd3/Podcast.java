package br.com.senac.atividadebdd3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Representa que no banco de dados haverá uma tabela com nome “podcast”, relacionada
//diretamente a essa classe.
public class Podcast {

    @Id
    //Indica que o atributo int id representa um identificador, a chave da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    Indica que o atributo tem valor gerado automaticamente pelo banco de dados.
    É o caso de ID, que, na tabela “podcast”, tem auto_increment. Como auto_increment
    foi utilizado como estratégia de geração automática de valor, é preciso especificar
    um parâmetro para a anottation strategy = GenerationType.IDENTITY.
    */
    
    //Declarando variáveis
    private int id;
    private String produtor;
    private String nomeEpisodio;
    private int numEpisodio;
    private String duracao;
    private String repositorio;
    
    //Funções para setar e recuperar as variáveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getNumEpisodio() {
        return numEpisodio;
    }

    public void setNumEpisodio(int numEpisodio) {
        this.numEpisodio = numEpisodio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }
    
}
