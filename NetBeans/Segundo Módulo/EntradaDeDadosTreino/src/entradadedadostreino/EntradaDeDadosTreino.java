package entradadedadostreino;

import java.util.Scanner;

public class EntradaDeDadosTreino {

    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int numero1, numero2, soma, subtracao, multiplicacao, divisao;
    
    System.out.print("Digite um número: ");
    numero1 = entrada.nextInt();
    
    System.out.print("Digite outro número: ");
    numero2 = entrada.nextInt();
    
    soma = numero1 + numero2;
    System.out.print("A soma dos dois números é " + soma);
    
    subtracao = numero1 - numero2;
    System.out.print("\nA subtração do primeiro pelo segundo número é " + subtracao);
    
    multiplicacao = numero1 * numero2;
    System.out.print("\nA multiplicação dos dois números é " + multiplicacao);
    
    divisao = numero1 / numero2;
    System.out.print("\nA divisão do primeiro pelo segundo número é " + divisao + "\n");
    }
    
}
