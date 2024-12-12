package abstractfactoryexemplo;

class FabricaAntigos implements Modelo {
    public Esportes getEsportes() {
        return new WiningEleven();
    }
    public RPG getRPG() {
        return new Zelda();
    }
  } 