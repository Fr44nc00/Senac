package OutrasClasses;

import java.sql.Date;

public class Filmes {
    private String nome;
    private Date data;
    private String categoria;
    
    public Filmes() {
    }
     //metodos gets e sets
    
    public String getNome() {
        return nome;    }

    public void setNome(String nome) {
        this.nome = nome;    }

    public Date getData() {
        return data;    }

    public void setData(Date data) {
        this.data = data;    }

    public String getCategoria() {
        return categoria;   }

    public void setCategoria(String categoria) {
        this.categoria = categoria;  }
}
