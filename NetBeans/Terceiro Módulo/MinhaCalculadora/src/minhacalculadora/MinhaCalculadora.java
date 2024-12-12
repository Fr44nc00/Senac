package minhacalculadora;

public class MinhaCalculadora {

    public static void main(String[] args) {
        
    Calculadora calc = new Calculadora();
    int v1, v2;
    v1 = 4;
    v2 = 2;
    
    System.out.println("Soma: " + calc.somar(v1, v2) );
    System.out.println("Subtração: " + calc.subtrair(v1, v2) );
    System.out.println("Multiplicação: " + calc.multiplicar(v1, v2) );
    System.out.println("Divisão: " + calc.dividir(v1, v2) );
    }
}
