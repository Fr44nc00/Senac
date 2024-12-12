package atividade3academia;

class ExerciciosResistencia implements Foco {
    public Corrida getCorrida1() {
        return new CCLD();
    }
    
    public Corrida getCorrida2() {
        return new Fartlek();
    }
    
    public Musculacao getMusculacao1() {
        return new Flexoes();
    }
    
    public Musculacao getMusculacao2() {
        return new ABL();
    }
  }