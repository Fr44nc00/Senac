package jappexamplelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JAppExampleList {
    
    public static void main(String[] args) {
        /*
        * 1o. passo: definir a lista que vamos armazenar os nomes
        */
        List<String> namesList = new ArrayList<>();
  
  
        /*
        * 2o. passo: criar a variável que controla a parada da nossa aplicação.
        * A opção que vai ser digitada pelo usuário
        */
        int option = 0;
  
        /*
        * Criação do objeto "keyboard" que vai capturar tudo o que for digitado
        */
        Scanner keyboard = new Scanner(System.in);
  
        /*
        * 4o. passo: criar a estrutura de repetição que vai manter nossa aplicação funcionando
        */
        do {            
            
            /*
            * 5o. passo: Exibir as opções para o usuário poder escolher
            */
    
            System.out.println("\nTrabalhando com List\n");
            System.out.println("1. Inserir nome");
            System.out.println("2. Verificar nome");
            System.out.println("3. Remover nome");
            System.out.println("4. Listar todos os nomes");
            System.out.println("5. Sair\n");
    
            /*
            * 6o. passo: ler a opção digitada pelo usuário
            */
            System.out.print("Digite sua opção [1 a 5]: ");
            option = keyboard.nextInt();
    
            /*
            * 7o. passo: criar o seletor da opção digitada pelo usuário
            */
            switch (option) {
            case 1:
                //Aqui vamos inserir o novo nome
                System.out.println("\nINSERIR NOME\n");
                /*
                * Para inserir o nome na lista vamos recorrer ao método "add(String name)" passando
                * como parâmetro a string digitada pelo usuário; Como esse método
                * retorna true "se inserido" e false "se não inserido". Vamos aproveitar 
                * para emitir uma mensagem de inserido com sucesso ou não.
                * Para termos um certo padrão vamos deixar os nomes com todas as letras
                * maiúsculas usando o método toUppercase().
                */
                System.out.print("Digite o nome: ");
                boolean itsInserted  =  namesList.add(keyboard.next().toUpperCase());
          
                if(itsInserted){
                    //se itsInserted = true
                    System.out.println("Nome inserido");
                }else{
                    //se itsInserted = false
                    System.out.println("FALHA! Nome não inserido.");
                }
          
                break;
          
            case 2:
                    //Aqui vamos buscar um nome na lista
                System.out.println("\nVERIFICAR NOME\n");
          
                /*
                * Aqui vamos buscar por um nome na lista, mas é conveniente antes de fazer isso,
                * verificar se a lista está vazia para isso utilizamos o método isEmpty() que retorna
                * true se a lista está vazia e false se contem 1 ou mais elementos
                */
                if(namesList.isEmpty()){
                    //se true exibe mensagem de lista vazia.
                    System.out.println("ATENÇÃO! Não há nomes na lista.");
                }else{
                    /*
                    * se false, precisamos pedir para o usuário o nome a ser procurado na lista.
                    * Podemos utilizar dois métodos: o contains(Object o) o equals(Object o).
                    * Como nossa lista é uma lista de String nosso objeto é um string.
                    * Como armazenamos os nomes com todas as letras em maiúsculo
                    * devemos procurar com as letras todos em maiusculo. Aqui vamos criar uma
                    * variável para armazenar o nome a ser encontrado
                    */
                    System.out.print("Digite o nome a ser localizado: ");
                    String name = keyboard.next().toUpperCase();
              
                    if(namesList.contains(name)){
                        /*
                        * se true foi encontrado
                        * podemos exibir o nome e a posição que ele foi encontrado
                        * para isso utilizamos o método indexOfObject(Object o) que retorna
                        * a posição que o nome foi encontrado. Lembre-se o nome está
                        * na variável name;
                        */
                  
                        int position = namesList.indexOf(name);
                        System.out.println("Nome: "+name+" | Posição: "+position+" da lista.");
                  
                    }else{
                        //se false não foi encontrado
                        System.out.println("ATENÇÃO! Nome não encontrado na lista.");
                    }
                
                }
          
            break;
                    
            case 3:
          
                //Aqui vamos remover um nome na lista
                System.out.println("\nREMOVER NOME\n");
                                
                /*
                * Aqui vamos buscar por um nome na lista, mas é conveniente antes de fazer isso,
                * verificar se a lista está vazia para isso utilizamos o método isEmpty() que retorna
                * true se a lista está vazia e false se contem 1 ou mais elementos
                */
                if(namesList.isEmpty()){
                    //se true exibe mensagem de lista vazia.
                    System.out.println("ATENÇÃO! Não há nomes na lista.");
                }else{
                    /*
                    * se false, precisamos pedir para o usuário o nome a ser removido da lista.
                    * O metodo responsável por isso é o remove(Object o). Esse método retorna
                    * true quando remove o objeto, e false quando não remove.
                    * Como nossa lista é uma lista de String nosso objeto é uma string.
                    * Como armazenamos os nomes com todas as letras em maiúsculo
                    * devemos procurar com as letras todos em maiusculo. Aqui vamos criar uma
                    * variável para armazenar o nome a ser encontrado
                    */
                    System.out.print("Digite o nome a ser deletado: ");
                    String name = keyboard.next().toUpperCase();
              
                    if(namesList.remove(name)){
                        /*
                        * se true foi deletado.
                        * Podemos exibir o nome e a mensagem de removido com sucesso.
                        */
                                        
                        System.out.println("Nome: "+name+" - Removido com sucesso.");
                  
                    }else{
                        //se false não foi encontrado
                        System.out.println("ATENÇÃO! Nome não encontrado na lista.");
                    }
                
                }
          
                break;
                    
                case 4:
                //Aqui vamos listar todos os nomes da lista
                System.out.println("\nLISTAR TODOS OS NOMES\n");
          
                /*
                * Aqui vamos buscar por  todos os nome na lista, mas é conveniente antes de fazer isso,
                * verificar se a lista está vazia para isso utilizamos o método isEmpty() que retorna
                * true se a lista está vazia e false se contem 1 ou mais elementos
                */
                if(namesList.isEmpty()){
                    //se true exibe mensagem de lista vazia.
                    System.out.println("ATENÇÃO! Não há nomes na lista.");
                }else{
                    /*
                    * se false, vamos ter passar por todas a posições da lista criada, pegar
                    * o objeto, no nosso caso, uma String e exibir em tela aqui vamos revisitar
                    * o laço de repetição for, que vai parar quando chegarmos ao fim da lista.
                    * para saber quando parar vamos usar o método size() que retorna o número
                    * de elementos tem na lista.
                    * Para pegar o elemento da lista utilizamos o método get(int index), esse
                    * metodo retorna o objeto da posição informada como parâmetro.
                    */
              
                    //variável que vai receber o nome da lista para ser exibido em tela
                    String name = "";
                
                    for (int i = 0; i < namesList.size(); i++) {
                        name = namesList.get(i);
                        System.out.println("Posição "+i+": "+name);
                    }
                }
        
                break;
                  
                case 5:
                    System.out.println("OBRIGADO POR UTILZAR NOSSO APLICATIVO - SENAC EAD");
                    break;
                  
                default:
                    //Caso o usuário digite algum valor diferente aos do menu vamos exibir essa mensagem
                    System.out.println("ATENÇÃO! Opção inválida!");
                    break;
            }
            
            
            } while (option != 5);

    }
}
