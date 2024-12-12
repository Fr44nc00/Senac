package atividade3academia;

public class OpcoesTreino {
    private Corrida cor1, cor2;
    private Musculacao musc1, musc2;
    private Foco fabricafoco;
    
    public OpcoesTreino(Foco fabrica)
    {
        fabricafoco = fabrica;
    }
    
    public Corrida getCorrida1() {
        return cor1;
    }
    
    public Corrida getCorrida2() {
        return cor2;
    }

    public Musculacao getMusculacao1() {
        return musc1;
    }
    
    public Musculacao getMusculacao2() {
        return musc2;
    }
    
    public void gerar()
    {
        cor1 = fabricafoco.getCorrida1();
        cor2 = fabricafoco.getCorrida2();
        musc1 = fabricafoco.getMusculacao1();
        musc2 = fabricafoco.getMusculacao2();
    }
  }