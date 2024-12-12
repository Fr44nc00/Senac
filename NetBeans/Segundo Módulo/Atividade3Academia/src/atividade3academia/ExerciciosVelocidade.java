package atividade3academia;

class ExerciciosVelocidade implements Foco {
    public Corrida getCorrida1() {
        return new Sprint();
    }
    
    public Corrida getCorrida2() {
        return new HIIT();
    }
    
    public Musculacao getMusculacao1() {
        return new BoxJump();
    }
    
    public Musculacao getMusculacao2() {
        return new Snatch();
    }
  }