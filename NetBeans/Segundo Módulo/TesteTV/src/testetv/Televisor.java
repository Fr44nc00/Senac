package testetv;

public class Televisor {
    byte canal;
    short volume;
    boolean ligada = false;

    public void ligar(){
        ligada = true;
        System.out.println("A TV está ligada.");
    }

    public void desligar(){
        ligada = false;
        System.out.println("A TV foi desligada.");
    }

    public void trocarCanal(byte novoCanal) {
        if(!ligada){ //! é o operador "não"
            System.out.println("A TV está desligada!");
        }
        else { //só realizará a operação se a TV estiver ligada
            if(novoCanal > 1 && novoCanal < 14) { //canais VHF vão de 2 a 13
                canal = novoCanal;
                System.out.println("Canal " + canal + " sintonizado");
            }else{
                System.out.println("Canal inválido");
            }
        }
    }

    public void aumentarVolume(){
        if(!ligada){ //só realizará a operação se a TV estiver ligada
            System.out.println("A TV está desligada!");
        }
        else {
            if(volume < 100){ //volume máximo = 100
                volume++;
            }
            System.out.println("Volume aumentado.");
        }
    }

    public void diminuirVolume(){
        if(!ligada){ //só realizará a operação se a TV estiver ligada
            System.out.println("A TV está desligada!");
        }
        else {
            if(volume > 0){ //volume mínimo = 0
                volume--; 
            }
            System.out.println("Volume diminuído.");
        }
    }
    
    public void display(){
        if(ligada){
            System.out.print("Canal " + canal + "; Volume atual: " + volume + "\n");
        }
    }
}
