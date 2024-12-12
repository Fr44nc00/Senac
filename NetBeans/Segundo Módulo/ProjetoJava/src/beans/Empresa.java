package beans;
            
public class Empresa {
    private int id;
    private String nomeempresa;
    private String areaatuacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeempresa() {
        return nomeempresa;
    }

    public void setNomeempresa(String nomeempresa) {
        this.nomeempresa = nomeempresa;
    }

    public String getAreaatuacao() {
        return areaatuacao;
    }

    public void setAreaatuacao(String areaatuacao) {
        this.areaatuacao = areaatuacao;
    }
    
    @Override
    //O método toString é a representação do objeto em string e significa que,
    //quando um objeto do tipo Empresa for chamado, ele mostrará o que estiver
    //sendo retornado por esse método.
    public String toString()
    {
        return this.nomeempresa;
    }
    
    @Override
    //definirá qual será a regra para comparar dois objetos do tipo Empresa.
    //Os dois objetos serão iguais, se o ID de ambos for igual. O código será este:
    public boolean equals (Object objeto)
    {
        Empresa e = (Empresa) objeto;
        if (this.id == e.getId()){
            return true;
        }
        else {
            return false;
        }
    }

}
