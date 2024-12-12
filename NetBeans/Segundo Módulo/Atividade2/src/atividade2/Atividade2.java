package atividade2;

import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Criação de novo pacote de viagem");
        System.out.println("Insira o tipo de transporte: ");
        String tipo = scanner.nextLine();
        System.out.println("Insira o valor do transporte: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Informe a descrição da hospedagem: ");
        String descricao = scanner.nextLine();
        System.out.println("Informe o valor da diária da hospedagem (em dólar): ");
        double diaria = scanner.nextDouble();
        scanner.nextLine(); 
        
        System.out.println("Informe o destino: ");
        String destino = scanner.nextLine();
        System.out.println("Informe a quantidade de dias de hospedagem: ");
        int dias = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Margem de lucro: ");
        double margemlucro = scanner.nextDouble();
        System.out.println("Taxas adicionais em dólar: ");
        double taxasadicionais = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Informe o nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Informe a forma de pagamento: ");
        String formadepagamento = scanner.nextLine();
        System.out.print("Informe a cotação do dólar no dia: ");
        double cotacaodolar = scanner.nextDouble();
        scanner.nextLine();
        
        
        Transporte transporte = new Transporte(tipo, valor);
        Hospedagem hospedagem = new Hospedagem(descricao, diaria);
        Pacotes pacotes = new Pacotes(transporte, hospedagem, destino, dias);
        Venda venda = new Venda(cliente, formadepagamento, pacotes);

        System.out.println("\nInformações do Pacote de Viagem:");
        System.out.println("Destino: " + pacotes.getdestino());
        System.out.println("Valor do transporte: " + pacotes.getvalortransporte() + " USD");
        System.out.println("Valor da hospedagem para " + dias + " dias: " + pacotes.getvalorhospedagem(dias) + " USD");
        System.out.println("Valor total do pacote (em dólar): " + pacotes.totalpacote(margemlucro, taxasadicionais) + " USD");

        System.out.println("\nInformações da venda:");
        venda.dadosvenda(cotacaodolar);
        
        
                
    }
    
}
