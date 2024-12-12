package atividade4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Atividade4 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Pagamentos> listaempresas = new ArrayList<>();
        Pagamentos pagamentos = null;
        System.out.println("Seja bem vindo ao Sistema Contábil!");
        
        
        char continuar;
        do{
            System.out.println("Por favor, insira os dados da empresa.\nNome: ");
            String nomeempresa = entrada.nextLine();
        
            pagamentos = new Pagamentos(nomeempresa);
        
            System.out.println("Tipo de imposto (PIS ou IPI): ");
            String tipoimposto = entrada.nextLine();
            
            if(tipoimposto.equalsIgnoreCase("PIS")){
                System.out.println("Insira o valor do crédito: ");
                double credito = entrada.nextDouble();
                System.out.println("Insira o valor do débito: ");
                double debito = entrada.nextDouble();
                entrada.nextLine();
                
                double total = credito + debito;
                
                PIS pis = new PIS( credito, debito, total);
                pagamentos.adicionarimposto(pis);
                
            }else if(tipoimposto.equalsIgnoreCase("IPI")){
                System.out.println("Insira o valor da alíquota: ");
                double aliquota = entrada.nextDouble();
                System.out.println("Insira o valor do Produto: ");
                double valorproduto = entrada.nextDouble();
                System.out.println("Insira o valor do frete: ");
                double frete = entrada.nextDouble();
                System.out.println("Insira o valor do seguro: ");
                double seguro = entrada.nextDouble();
                System.out.println("Insira o valor de outras despesas: ");
                double outrasdespesas = entrada.nextDouble();
                entrada.nextLine();
                
                double basecalculo = valorproduto + frete + seguro + outrasdespesas;
                
                IPI ipi = new IPI(aliquota,valorproduto,frete,seguro,outrasdespesas,basecalculo);
                pagamentos.adicionarimposto(ipi);
            }
            
            listaempresas.add(pagamentos);
            
            System.out.println("Deseja continuar?\nSim (S) / Não (N)\n");
            continuar = entrada.next().toUpperCase().charAt(0);
            }while(continuar == 'S');
        
         for (Pagamentos empresa : listaempresas) {
            empresa.totalimpostos();
            empresa.descricaoimpostos();
         }
    }
    
}
