
package modulocontabil;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ModuloContabil {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Pagamentos> listaEmpresas = new ArrayList<>();
        Pagamentos pagamentos = null;
        System.out.println("--BEM VINDO AO SISTEMA CONTÁBIL--");
        
        
        String continuar;
        do{
            System.out.println("DIGITE O NOME DA EMPRESA: ");
            String nomeEmpresa = entrada.nextLine();
        
            pagamentos = new Pagamentos(nomeEmpresa);
        
            System.out.println("DIGITE O TIPO DE IMPOSTO: (Pis ou Ipi)");
            String tipoImposto = entrada.nextLine();
            
            if(tipoImposto.equalsIgnoreCase("Pis")){
                System.out.println("Digite o valor do crédito: ");
                double credito = entrada.nextDouble();
                System.out.println("Digite o valor do débito: ");
                double debito = entrada.nextDouble();
                entrada.nextLine();
                
                double total = credito + debito;
                
                Pis pis = new Pis( credito, debito, total);
                pagamentos.adicionarImposto(pis);
                
            }else if(tipoImposto.equalsIgnoreCase("Ipi")){
                System.out.println("Digite o valor da alíquota: ");
                double aliquota = entrada.nextDouble();
                System.out.println("Digite o valor do Produto: ");
                double valorProduto = entrada.nextDouble();
                System.out.println("Digite o valor do frete: ");
                double frete = entrada.nextDouble();
                System.out.println("Digite o valor do seguro: ");
                double seguro = entrada.nextDouble();
                System.out.println("Digite o valor de outras despesas: ");
                double outrasDespesas = entrada.nextDouble();
                entrada.nextLine();
                
                double baseDeCalculo = valorProduto + frete + seguro + outrasDespesas;
                
                Ipi ipi = new Ipi(aliquota,valorProduto,frete,seguro,outrasDespesas,baseDeCalculo);
                pagamentos.adicionarImposto(ipi);
            }
            
            listaEmpresas.add(pagamentos);
            
            System.out.println("Deseja continuar? (Sim ou não)");
            continuar = entrada.nextLine();
        }while(continuar.equalsIgnoreCase("Sim"));
        
         for (Pagamentos empresa : listaEmpresas) {
            empresa.calcularTotalImpostos();
            empresa.exibirDescricaoImpostos();
         }
    }
    
}
