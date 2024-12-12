package br.com.senac.financasjpa.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Receita {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String descricao;

private double valor;

    @ManyToOne
    @JoinColumn(name="conta_id")
    //Note ainda que há uma anotação @JoinColum. Ela é usada para identificar qual a coluna
    //faz a referência na chave estrangeira – neste caso, é a coluna “conta_id” da tabela
    //“receita” que referencia a tabela “conta”. Na realidade, essa anotação é até
    //dispensável quando se usa o padrão “ <nome_tabela>_id” (como em “conta_id”)
    //em sua tabela, mas, caso a coluna não siga esse padrão de nomeação, é necessário 
    //usar a anotação.
    private Conta conta;

    private LocalDate data;

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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
