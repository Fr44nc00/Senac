package atividade1item1;

import java.util.Scanner;

public class Atividade1Item1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int convidados, cadeirasextras;
        
        System.out.print("Bem vindo(a) ao hotel Bela Vista! Quantos convidados estarão no evento?\n");
        convidados = entrada.nextInt();
        
        if(convidados > 350 || convidados <= 0){
            System.out.print("Número de convidados inválido.\n");
        }else if(convidados <= 220){
            cadeirasextras = convidados - 150;
            
            if(cadeirasextras > 0){
                System.out.print("Use o auditório Alfa e adicione " + cadeirasextras + " cadeiras.");
            }else
                System.out.print("Use o auditório Alfa.");
        }else
            System.out.print("Use o auditório Beta.");
    }
    
}
