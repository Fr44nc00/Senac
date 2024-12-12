package entradadedadosexemplos;

import java.util.Scanner;

public class EntradaDeDadosExemplos {

    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int idade, meses, fimNome, tamanhoNome;
    String nome, primeiroNome;
  
    System.out.print("Digite a idade: ");
    //lê um número inteiro do console
    idade = entrada.nextInt();
  
    meses = idade * 12;
    System.out.println("A pessoa viveu " + meses + " meses");
    
    //
    
    float celsius, farenheit, kelvin;
  
    System.out.print("Informe a temperatura em ºC: ");
    celsius = entrada.nextFloat();
  
    farenheit = celsius * 1.8f + 32;
    kelvin = celsius + 273.15f;
    System.out.println(celsius + "ºC correspondem a " + farenheit + "F e " + kelvin + "K.");
    
    //
    
    final float pi = 3.1416f;
    float raio;
  
    raio = entrada.nextFloat();
  
    float area = pi * raio * raio;
  
    System.out.println("A área do círculo é " + area + "cm");

    
    //
  
    System.out.print("Informe nome e sobrenome: ");
    nome = entrada.nextLine();
  
    //tamanho do nome completo
    tamanhoNome = nome.length();
    //encontra o índice no qual ocorre o primeiro caractere de espaço
    fimNome = nome.indexOf(" ");
    //extrai o primeiro nome
    primeiroNome = nome.substring(0, fimNome);
  
    //mostra na tela o resultado
    System.out.println("Tamanho total: " + tamanhoNome + " caracteres;\nPrimeiro nome: " + primeiroNome);
    }   
}
