package atividade1item5;

import java.util.Scanner;

public class Atividade1Item5 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int i = 0, j = 0;
        char ocupacao;
        boolean continuar = true;
        String[][] quartos = new String[5][4];
        
        while (continuar) {
            System.out.print("Bem vindo(a) ao Hotel Bela Vista! Por favor, informe o andar que deseja ocupar (1 a 4): ");
            i = entrada.nextInt();

            if (i < 1 || i > 4) {
                System.out.println("Andar inválido.");
                continue;
            }

            System.out.print("Agora informe o quarto (1 a 3): ");
            j = entrada.nextInt();

            if (j < 1 || j > 3) {
                System.out.println("Número do quarto inválido.");
                continue;
            }

            System.out.print("O quarto está ocupado? (S/N): ");
            ocupacao = entrada.next().charAt(0);

            switch (ocupacao) {
                case 'S':
                case 's':
                    quartos[i][j] = "X";
                    break;
                case 'N':
                case 'n':
                    quartos[i][j] = "--";
                    break;
                default:
                    System.out.println("Resposta inválida. Use 'S' para ocupado e 'N' para desocupado.");
                    continue;
            }

            System.out.print("Deseja informar outra ocupação? (S/N): ");
            ocupacao = entrada.next().charAt(0);
            if (ocupacao == 'N' || ocupacao == 'n') {
                continuar = false;
            }
        }

        System.out.println("Tabela de Quartos:");
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 3; j++) {
                System.out.print("| " + quartos[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}
