package atividade1item3;

import java.util.Scanner;

public class Atividade1Item3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "latin1");
        int valordiaria, total = 0, idade, grat = 0, meia = 0;
        String nome;
        boolean continuarInserindo = true;

        System.out.print("Qual o valor da diária do hotel? ");
        valordiaria = entrada.nextInt();
        entrada.nextLine();
        
        do {
            System.out.print("Insira o nome do hóspede ou digite PARE para interromper o código: ");
            nome = entrada.nextLine();

            if (nome.equalsIgnoreCase("PARE")) {
                System.out.println("Total de hospedagens: R$ " + total + "; " + grat + " gratuidade(s); " + meia + " meia(s)");
                continuarInserindo = false;
            } else {
                System.out.print("Insira a idade do hóspede: ");
                idade = entrada.nextInt();
                entrada.nextLine();

                if (idade <= 4) {
                    System.out.println(nome + " possui gratuidade.");
                    grat++;
                } else if (idade >= 80) {
                    System.out.println(nome + " paga meia.");
                    total = total + (valordiaria / 2);
                    meia++;
                } else {
                    total = total + valordiaria;
                }
            }
        } while (continuarInserindo);
    }
}