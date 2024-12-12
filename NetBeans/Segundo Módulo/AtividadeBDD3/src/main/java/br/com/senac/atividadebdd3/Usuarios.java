package br.com.senac.atividadebdd3;

public class Usuarios {
    //Declarando variáveis
    private int id;
    private String login;
    private String senha;
    private String tipo;

    //Funções para setar e recuperar as variáveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
