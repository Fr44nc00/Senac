package whiletreino;

import java.util.Scanner;

public class WhileTreino {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char resposta;
        int n, resultado, nota, quantidadenotas, total, media;
        resultado = 0;
        quantidadenotas = 0;
        total = 0;
        
        System.out.print("Digite um número entre 1 e 10: ");
        n = entrada.nextInt();
        resultado = n;
        
        System.out.print("O fatorial do número " + n + " é: " + n);
        if(n > 1){
            do{
                resultado--;
                System.out.print(" * " + resultado);
                if(resultado == 1){
                    resultado--;
                }
            }while(resultado > 1);
        }
        
        System.out.print("\nDeseja informar uma nota?\n(S) Sim (N) Não\n");
        resposta = entrada.next().charAt(0);
        
        do{
            System.out.print("Informe uma nota: ");
            nota = entrada.nextInt();
            total = total + nota;
            quantidadenotas++;
            
            System.out.print("\nDeseja informar outra nota? ");
            resposta = entrada.next().charAt(0);
        }while(resposta == 'S');
        
        media = total / quantidadenotas;
        if(media >= 6){
            System.out.print("Aprovado.");
        }else
            System.out.print("Reprovado.");
    }
}
