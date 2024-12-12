package atividade3academia;

import java.util.Scanner;

public class Atividade3Academia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de exercícios da academia\nQual o foco do seu treino?\n1 - Resistência 2 - Velocidade");
        int opc = sc.nextInt();

        Foco foco = null;
        switch (opc) {
            case 1:
                foco = new ExerciciosResistencia();
                break;
            case 2:
                foco = new ExerciciosVelocidade();
                break;
        }

        OpcoesTreino opcao = new OpcoesTreino(foco);
        opcao.gerar();

        System.out.println("Exercícios de corrida: " + opcao.getCorrida1().toString() + ", " + opcao.getCorrida2().toString());
        System.out.println("Exercícios de musculação: " + opcao.getMusculacao1().toString() + ", " + opcao.getMusculacao2().toString());
    }
    
}
