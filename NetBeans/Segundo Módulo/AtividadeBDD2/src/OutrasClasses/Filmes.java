//pacote
package OutrasClasses; 

//importando bibliotecas necessárias
import java.sql.Date;

public class Filmes {
    //declarando as variáveis
    private int id;
    private String nome;
    private Date data;
    private String categoria;
    
    public Filmes() {
    }
    
    //abaixo os métodos get (para retornar a variável) e set (para definir a variável) 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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
    
    @Override
    //O método toString é a representação do objeto em string e significa que,
    //quando um objeto do tipo Filmes for chamado, ele mostrará o que estiver
    //sendo retornado por esse método.
    public String toString()
    {
        return this.nome;
    }
    
    @Override
    //definirá qual será a regra para comparar dois objetos do tipo Filmes.
    //Os dois objetos serão iguais se o ID de ambos for igual.
    public boolean equals (Object objeto)
    {
        Filmes f = (Filmes) objeto;
        if (this.id == f.getId()){
            return true;
        }
        else {
            return false;
        }
    }
}
