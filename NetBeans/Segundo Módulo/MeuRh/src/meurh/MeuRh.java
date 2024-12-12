
package meurh;
import java.util.ArrayList;
import java.util.Scanner;
public class MeuRh {
    public static void main(String[] args) {
       ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
       Scanner entrada = new Scanner(System.in);
       
       int numFuncionarios = 3;
       
       for(int i = 0;i < numFuncionarios;i++){
           System.out.println("Informe o tipo de funcionário:('A' para assalariado 'B' para horista) ");
           String tipoFuncionario = entrada.nextLine();
           
           if(tipoFuncionario.equalsIgnoreCase("A")){
               System.out.println("Digite o nome: ");
               String nome = entrada.nextLine();
               System.out.println("Digite o cpf: ");
               String cpf = entrada.nextLine();
               System.out.println("Digite o endereço: ");
               String endereco = entrada.nextLine();
               System.out.println("Digite o telefone: ");
               String telefone = entrada.nextLine();
               System.out.println("Digite o setor: ");
               String setor = entrada.nextLine();
               System.out.println("Digite o salário: ");
               double salario = entrada.nextDouble();
               entrada.nextLine();
               
               FuncionarioAssalariado assalariado = new FuncionarioAssalariado(nome,cpf,endereco,telefone,setor,salario); 
               listaFuncionarios.add(assalariado);    
           }else if(tipoFuncionario.equalsIgnoreCase("B")){
               System.out.println("Digite o nome: ");
               String nomeHorista = entrada.nextLine();
               System.out.println("Digite o cpf: ");
               String cpfHorista = entrada.nextLine();
               System.out.println("Digite o endereço: ");
               String enderecoHorista = entrada.nextLine();
               System.out.println("Digite o telefone: ");
               String telefoneHorista = entrada.nextLine();
               System.out.println("Digite o setor: ");
               String setorHorista = entrada.nextLine();
               System.out.println("Digite a quantidade de horas trabalhadas: ");
               double horas = entrada.nextDouble();
               System.out.println("Digite o valor da hora: ");
               double valorHora = entrada.nextDouble();
               entrada.nextLine();
              
               
               FuncionarioHorista horista = new FuncionarioHorista(nomeHorista,cpfHorista,enderecoHorista,telefoneHorista,setorHorista,horas,valorHora);
               listaFuncionarios.add(horista);
           }else{
               System.out.println("Tipo de funcionário inválido!");
               i--;
           }       
       }
             for (Funcionario funcionario : listaFuncionarios) {                 
                  funcionario.mostrarDados();
                  funcionario.calcularSalario();
             }
             
        System.out.println("\n");
        System.out.println("Digite em porcentagem o valor do aumento dos funcionários: ");  
        double aumento = entrada.nextDouble();
        
             for(Funcionario funcionario : listaFuncionarios){   
                  funcionario.aumentarSalario(aumento);
                  funcionario.mostrarDados();
             }
    }
    
}
