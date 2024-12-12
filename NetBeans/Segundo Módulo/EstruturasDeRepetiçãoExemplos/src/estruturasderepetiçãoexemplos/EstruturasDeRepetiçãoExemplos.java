package estruturasderepetiçãoexemplos;

import java.util.Scanner;

public class EstruturasDeRepetiçãoExemplos {

    //LacoFor
    public static void main(String[] args) {
        int contador;
                
        // INICIALIZAÇÃO: atribua o número 1 à variável contador
        // CONDIÇÃO: atribua a condição menor ou igual a 10
        // INCREMENTO ou DECREMENTO: use o incremento, pois quer-se fazer uma contagem na ordem crescente
        for ( contador = 1; contador <= 10; contador++) {
            System.out.println(contador);
            
        }
        
        //Tabuada
        
        Scanner entrada = new Scanner(System.in);
        int numero, resultado;

        System.out.print("Informe o número: ");
        numero = entrada.nextInt();

        for(int i = 1; i <= 10; i++)
        {
            resultado = numero * i;
            System.out.println(numero + " X " + i + " = " + resultado);
        }
    }
    
}
