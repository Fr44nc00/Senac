package abstractfactoryexemplo;

abstract class Games {
    private String nome;

    public Games(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return nome;
    }
}