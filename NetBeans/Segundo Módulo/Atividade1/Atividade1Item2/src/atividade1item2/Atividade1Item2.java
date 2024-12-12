package atividade1item2;

import java.util.Scanner;

public class Atividade1Item2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nome1, nome2;
        int idade1, idade2;
        
        System.out.print("Insira o nome do primeiro hóspede: ");
        nome1 = entrada.nextLine();
        System.out.print("Insira a idade do primeiro hóspede: ");
        idade1 = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Insira o nome do segundo hóspede: ");
        nome2 = entrada.nextLine();
        System.out.print("Insira a idade do segundo hóspede: ");
        idade2 = entrada.nextInt();
        
        if(idade2 > idade1){
            if(idade2 >= 60){
                System.out.print("Quarto A: " + nome2 + " com desconto de 40%; Quarto B: " + nome1);
            } else
                System.out.print("Quarto A: " + nome2 + "; Quarto B: " + nome1);
        } else if(idade1 >= 60){
            System.out.print("Quarto A: " + nome1 + " com desconto de 40%; Quarto B: " + nome2);
        } else {
            System.out.print("Quarto A: " + nome1 + "; Quarto B: " + nome2);
        }
    }
}
