package exemploswhile;

import java.util.Scanner;

public class ExemplosWhile {

    public static void main(String[] args) {

        int contador = 1;

        while (contador <= 10) {
            System.out.println("Este é o número: " + contador);
            contador++;
        }
        
        //Do While
        
        int i = 1;

        do {
            System.out.println("Número: " + i);
            i++;
        } while (i <= 10);
        
        //Velocista
        
        Scanner entrada = new Scanner(System.in);
          
          float tempoVolta, menorTempo;
          String continuar = "S";
         
          //inicializando o menor tempo com o maior valor possível
          // (qualquer primeiro valor informado será menor que este)
          menorTempo = Float.MAX_VALUE;
          
          while(continuar.equals("S"))
          {
              System.out.print("Informe o tempo (s) da volta do velocista:");
              tempoVolta = entrada.nextFloat();
  
              //este nextLine é necessário para que o próximo nextLine, ao fim do laço, não falhe
              entrada.nextLine(); //consome o "enter" digitado pelo usuário
  
              if(menorTempo > tempoVolta)
              {
                  menorTempo = tempoVolta;
              }
  
              System.out.print("Deseja informar novo tempo? S/N ");
              continuar = entrada.nextLine();
          }
          
          System.out.println("A menor volta do velocista foi de " + menorTempo + " segundos.");
          
        //Idade
        
        int idade;
          
        do{
            System.out.println("Informe uma idade válida (entre 0 e 150)");
            idade = entrada.nextInt();
        }while(idade < 0 || idade > 150);
          
        System.out.println("obrigado por informar uma idade válida");
    }
}
