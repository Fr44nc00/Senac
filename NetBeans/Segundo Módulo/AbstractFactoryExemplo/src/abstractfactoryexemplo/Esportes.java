package abstractfactoryexemplo;

abstract class Esportes extends Games {
    public Esportes(String nome) {
        super(nome); 
  //o comando super(), faz com que chamamos o mesmo atributo da Classe pai.
    }
  }