package atividade3;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {
       ArrayList<Funcionário> listafuncionarios = new ArrayList<Funcionário>();
       Scanner entrada = new Scanner(System.in);
       
       int quantfuncionarios = 3;
       
       for(int i = 0;i < quantfuncionarios;i++){
           System.out.println("Informe o tipo de funcionário:(A para assalariado / H para horista) ");
           String tipo = entrada.nextLine();
           
           if(tipo.equalsIgnoreCase("A")){
               System.out.println("Insira os dados do funcionário:\nNome: ");
               String nomeassalariado = entrada.nextLine();
               System.out.println("CPF: ");
               String cpfassalariado = entrada.nextLine();
               System.out.println("Endereço: ");
               String enderecoassalariado = entrada.nextLine();
               System.out.println("Telefone para contato: ");
               String telefoneassalariado = entrada.nextLine();
               System.out.println("Setor: ");
               String setorassalariado = entrada.nextLine();
               System.out.println("Salário: ");
               double salario = entrada.nextDouble();
               entrada.nextLine();
               
               Assalariado assalariado = new Assalariado(nomeassalariado,cpfassalariado,enderecoassalariado,telefoneassalariado,setorassalariado,salario); 
               listafuncionarios.add(assalariado);    
           }else if(tipo.equalsIgnoreCase("H")){
               System.out.println("Insira os dados do funcionário:\nNome: ");
               String nomehorista = entrada.nextLine();
               System.out.println("CPF: ");
               String cpfhorista = entrada.nextLine();
               System.out.println("Endereço: ");
               String enderecohorista = entrada.nextLine();
               System.out.println("Telefone para contato: ");
               String telefonehorista = entrada.nextLine();
               System.out.println("Setor: ");
               String setorhorista = entrada.nextLine();
               System.out.println("Quantidade de horas trabalhadas: ");
               double horas = entrada.nextDouble();
               System.out.println("Valor da hora: ");
               double valorhora = entrada.nextDouble();
               entrada.nextLine();
              
               
               Horista horista = new Horista(nomehorista,cpfhorista,enderecohorista,telefonehorista,setorhorista,horas,valorhora);
               listafuncionarios.add(horista);
           }else{
               System.out.println("Tipo de funcionário inválido. Tente novamente.");
               i--;
           }       
       }
             for (Funcionário funcionario : listafuncionarios) {                 
                  funcionario.dados();
                  funcionario.salario();
             }
             
        System.out.println("\n");
        System.out.println("Digite em porcentagem o valor do aumento dos funcionários: ");  
        double aumento = entrada.nextDouble();
        
             for(Funcionário funcionario : listafuncionarios){   
                  funcionario.aumento(aumento);
                  funcionario.dados();
             }
    }
    
}
