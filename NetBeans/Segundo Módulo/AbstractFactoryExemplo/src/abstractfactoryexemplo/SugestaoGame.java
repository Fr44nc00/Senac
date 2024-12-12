package abstractfactoryexemplo;

public class SugestaoGame {
    private Esportes gameEsporte;
    private RPG gameRPG;
    private Modelo fabricaModelo;
    
    public SugestaoGame(Modelo fabrica)
    {
        fabricaModelo = fabrica;
    }
    
    public Esportes getGameEsporte() {
        return gameEsporte;
    }

    public RPG getGameRPG() {
        return gameRPG;
    }
    
    public void gerar()
    {
        gameEsporte = fabricaModelo.getEsportes();
        gameRPG = fabricaModelo.getRPG();
    }
  }
