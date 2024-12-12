package atividade1item4;

import java.util.Scanner;

public class Atividade1Item4 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "latin1");
        int opcao, i = 0;
        boolean continuar = true, encontrado = false;
        String nomehospede;
        String[] nome = new String[15];
        
        while (continuar) {
            System.out.print("Seja bem vindo(a) ao Hotel Bela Vista! O que deseja fazer?\n1 - Cadastrar novo hóspede / 2 - Pesquisar hóspedes / 3 - Sair\n");
            opcao = entrada.nextInt();
        
            switch (opcao) {
                case 1:
                    if (i == 15) {
                        System.out.print("Máximo de cadastros atingido.");
                    } else {
                        entrada.nextLine();
                        System.out.print("Insira o nome do novo hóspede: ");
                        nome[i] = entrada.nextLine();
                        i++;
                    }
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.print("Insira o nome que deseja pesquisar: ");
                    nomehospede = entrada.nextLine();
                    encontrado = false;
                    
                    for (int j = 0; j < i; j++) {
                        if (nome[j] != null && nome[j].equalsIgnoreCase(nomehospede)) {
                            System.out.println("Hóspede " + nome[j] + " foi encontrado no índice " + (j + 1) + ".");
                            encontrado = true;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Hóspede não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Volte sempre!");
                    continuar = false;
                    break;
                default: 
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
