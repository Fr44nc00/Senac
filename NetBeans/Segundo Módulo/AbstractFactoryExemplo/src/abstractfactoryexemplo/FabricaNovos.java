package abstractfactoryexemplo;

class FabricaNovos implements Modelo {
    public Esportes getEsportes() {
        return new Fifa();
    }
    public RPG getRPG() {
        return new EldenRing();
    }
  } 