package estruturascondicionais;

import java.util.Scanner;

public class EstruturasCondicionais {

    public static void main(String[] args) {
        int num1 = 10, num2 = 15, num3 = 20;
        System.out.println( num1 > num2 ); //false
        System.out.println( num1 != num2 ); //true
        //operador NÃO
        System.out.println(!(num1 < num2)); //false
        //operador E
        System.out.println( num1 < num2 && num2 < num3); //true
        //operador OU
        System.out.println( num1 >= num2 || num1 >= num3); //false
        //expressão extensa
        System.out.println( (num1 > num2 && num2 > num3) || (num2 +10 > num3 ) ); //true
        
        //
        
        String valorA = "Este é um texto";
        String valorB = "Este é outro texto";
        String valorC = new String("Este é outro texto");
        //comparando valorA e valorB
        System.out.println(valorA.equals(valorB));//false
        //comparando valorA com um texto equivalente
        System.out.println(valorA.equals("Este é um texto"));//true
        //comparando valores dos objetos
        System.out.println(valorB.equals(valorC));//true
        //comparando objetos, e não valores
        System.out.println(valorB == valorC);//false
        
        //
        
        int a, b, resultado;
        
        Scanner entrada = new Scanner(System.in, "latin1");//permite acentos
 
        System.out.print("Entre o valor <A>: ");
        a = entrada.nextInt();
        System.out.print("Entre o valor <B>: ");
        b = entrada.nextInt();
        resultado = a + b;

        if (resultado > 10) {
          System.out.println("Resultado = " + resultado);
        }     
        System.out.println("Fim do programa");
        
        //
        
        int idade;
        String nome;
        
        System.out.println("Digite o seu nome:");
        nome = entrada.nextLine();
        System.out.println("Digite sua idade:");
        idade = entrada.nextInt();
        
        if (idade >= 18) 
        {
            System.out.println(nome + ", sua idade é " + idade + " anos e você é maior de idade!");  
        }
        
        //
        
        int a2, b2, resultado2;
        System.out.println();
        System.out.print("Entre o valor <A>: ");
        a2 = entrada.nextInt();
        System.out.print("Entre o valor <B>: ");
        b2 = entrada.nextInt();
        resultado2 = a2 + b2;
        System.out.println();
        if (resultado > 10) {
            System.out.println(" A soma dos números é: " + resultado2 + " ,que ultrapassa o valor dez.");
        } else {
            System.out.println(" A soma dos números é: " + resultado2 + " ,que não ultrapassa o valor dez.");
        }
        System.out.println("Fim do programa");
        
        //
        
        int idade2, senha, mes;
        String nome2;
        
        System.out.println("--Solicitando dados ao usuário--");
        System.out.println("Digite seu nome:");
        nome2 = entrada.nextLine();
        System.out.println("Digite a sua idade:");
        idade2 = entrada.nextInt();
        System.out.println("Digite o número correspondente ao mês que você nasceu:");
        mes = entrada.nextInt();
        
        System.out.println("\n---Acesso ao sistema---");
        System.out.println("Digite a sua senha:");
        senha = entrada.nextInt();
        
        if (senha == idade2 || senha == mes) {
            System.out.println("Olá " + nome2 + ", acesso permitido!");
            
        } else {
            System.out.println("Acesso negado!!");
        }
        
        //
        
        float nota1, nota2, media;
        
        System.out.print("Digite a primeira nota: ");
        nota1 = entrada.nextFloat();
        System.out.print("Digite o segunda nota: ");
        nota2 = entrada.nextFloat();
        media = (nota1 + nota2)/2;
        
        if(media >= 7)//num1 é maior de todos
        {
            System.out.println("Aprovado");
        }
        else 
        {
            if(media >= 5 && media < 7) 
            {
                System.out.println("Recuperação");
            }
            else
            {
                System.out.println("Reprovado");
            }
        }
        
        //
        
        int dia;
        System.out.print("Entre um valor referente a um dia da semana: ");
        dia = entrada.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default: 
                System.out.println("Dia inválido");
                break;
        }
        
        //

        String forma;
        float raio, base, altura, area;

        System.out.println("Digite a forma da qual quer calcular área (retangulo, triangulo ou circulo):");
        forma = entrada.nextLine();
        
        switch(forma)
        {
            case "retangulo":
                System.out.println("Digite primeiro a base depois a altura:");
                base = entrada.nextFloat();
                altura = entrada.nextFloat();
                area = base * altura;
                System.out.println("Área do retângulo: " + area);
                break;

            case "triangulo":
                System.out.println("Digite primeiro a base depois a altura:");
                base = entrada.nextFloat();
                altura = entrada.nextFloat();
                area = base * altura / 2;
                System.out.println("Área do triângulo: " + area);
                break;

            case "circulo":
                System.out.println("Digite o raio:");
                raio = entrada.nextFloat();
                area = 3.1416f * raio * raio;
                System.out.println("Área do círculo: " + area);
                break;

            default:
                System.out.println("Forma não reconhecida");
                break;
        }
        
        //
        
            switch(forma)
            {
            case "retângulo":
            case "retangulo":
                System.out.println("Digite primeiro a base depois a altura:");
                base = entrada.nextFloat();
                altura = entrada.nextFloat();
                area = base * altura;
                System.out.println("Área do retângulo: " + area);
                break;

            case "triângulo":
            case "triangulo":
                System.out.println("Digite primeiro a base depois a altura:");
                base = entrada.nextFloat();
                altura = entrada.nextFloat();
                area = base * altura / 2;
                System.out.println("Área do triângulo: " + area);
                break;

            case "círculo":
            case "circulo":
                System.out.println("Digite o raio:");
                raio = entrada.nextFloat();
                area = 3.1416f * raio * raio;
                System.out.println("Área do círculo: " + area);
                break;

            default:
                System.out.println("forma não reconhecida");
                break;
        }
    }
    
}
