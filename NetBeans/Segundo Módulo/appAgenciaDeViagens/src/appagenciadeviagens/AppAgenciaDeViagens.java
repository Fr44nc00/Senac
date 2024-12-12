
package appagenciadeviagens;

import java.util.Scanner;
public class AppAgenciaDeViagens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--NOVO PACOTE DE VIAGEM--");
        System.out.println("Tipo de transporte: ");
        String tipo = scanner.nextLine();
        System.out.println("Valor do transporte: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Informe a descrição da hospedagem: ");
        String descricao = scanner.nextLine();
        System.out.println("Informe o valor da diária da hospedagem em dólar: ");
        double valorDiaria = scanner.nextDouble();
        scanner.nextLine(); 
        
        System.out.println("Informe o destino: ");
        String destino = scanner.nextLine();
        System.out.println("Quantidade de dias: ");
        int numDias = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Margem de lucro: ");
        double margemLucro = scanner.nextDouble();
        System.out.println("Taxas adicionais em Dólar: ");
        double taxasAdicionais = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Informe o nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Informe a forma de pagamento: ");
        String formaPagamento = scanner.nextLine();
        System.out.print("Informe a cotação do dólar no dia: ");
        double cotacaoDolar = scanner.nextDouble();
        scanner.nextLine();
        
        
        Transporte transporte = new Transporte(tipo, valor);
        Hospedagem hospedagem = new Hospedagem(descricao, valorDiaria);
        PacoteDeViagem pacoteDeViagem = new PacoteDeViagem(transporte, hospedagem, destino, numDias);
        Venda venda = new Venda(cliente, formaPagamento, pacoteDeViagem);

        System.out.println("\nInformações do Pacote de Viagem:");
        System.out.println("Destino: " + pacoteDeViagem.getDestino());
        System.out.println("Valor do Transporte: " + pacoteDeViagem.getValorTransporte() + " USD");
        System.out.println("Valor da Hospedagem para " + numDias + " dias: " + pacoteDeViagem.getValorHospedagem(numDias) + " USD");
        System.out.println("Valor Total do Pacote em Dólar: " + pacoteDeViagem.calcularTotalPacote(margemLucro, taxasAdicionais) + " USD");

        System.out.println("\nInformações da Venda:");
        venda.mostrarDadosVenda(cotacaoDolar);
        
        
                
    }
    
}
