package tiposdedados;

public class TiposDeDados {

  public static void main(String[] args) {
        // "\n" é usado para realizar uma quebra de linha
        System.out.println("Tipos de dados em Java: \n"
       + "\nMenor Byte: " + Byte.MIN_VALUE+ "\nMaior Byte: " + Byte.MAX_VALUE
       + "\nMenor Short Int: " + Short.MIN_VALUE + "\nMaior Short Int: " + Short.MAX_VALUE
       + "\nMenor Int: " + Integer.MIN_VALUE + "\nMaior Int: " + Integer.MAX_VALUE
       + "\nMenor Long: " + Long.MIN_VALUE + "\nMaior Long: " + Long.MAX_VALUE
       + "\nMenor Float: " + Float.MIN_VALUE + "\nMaior Float: " + Float.MAX_VALUE
       + "\nMenor Double: " + Double.MIN_VALUE + "\nMaior Double: " + Double.MAX_VALUE);
       
       //Casting (mudar o tipo de uma variável)
       double var_dbl = 10.5;
       int var_int = (int) var_dbl; //10 (perde o .5)
       
       //Boolean (falso ou verdadeiro)
       boolean estouAprendendoJava = true;
       boolean sereiBomSeNaoPraticar = false;
       System.out.println(estouAprendendoJava); // Mostra true
       System.out.println(sereiBomSeNaoPraticar); // Mostra false

       boolean resultado = 10 > 5;
       System.out.println(resultado); //Mostra true
       
       int idade = 30, meses;
       meses = idade * 12;
       System.out.println("A pessoa viveu " + meses + " meses");
       
       float celsius = 20, farenheit, kelvin;
       farenheit = celsius * 1.8f + 32;
       kelvin = celsius + 273.15f;
       System.out.println(celsius + "ºC correspondem a " + farenheit + "F e " + kelvin + "K.");
       
       final float pi = 3.1416f;
       float raio = 10;
       float area = pi * raio * raio;
       System.out.println("A área do círculo é " + area + "cm");
       
       String nome = "João da Silva", primeiroNome;
       int fimNome, tamanhoNome;
    
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
