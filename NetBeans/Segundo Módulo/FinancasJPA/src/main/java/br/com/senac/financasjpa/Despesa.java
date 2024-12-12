package br.com.senac.financasjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
//Representa que no banco de dados haverá uma tabela com nome “despesa”, relacionada
//diretamente a essa classe.
public class Despesa {

    @Id
    //Indica que o atributo int id representa um identificador, a chave da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    Indica que o atributo tem valor gerado automaticamente pelo banco de dados.
    É o caso de ID, que, na tabela “despesa”, tem auto_increment. Como auto_increment
    foi utilizado como estratégia de geração automática de valor, é preciso especificar
    um parâmetro para a anottation strategy = GenerationType.IDENTITY.
    */
    
    private int id;

    private String descricao;

    private double valor;

    private LocalDate data;

    /**getters e setter
      * @return s*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}