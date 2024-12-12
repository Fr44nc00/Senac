package alunoapp;

public class Aluno {
    String nome;
    int matricula;
    String cpf;
    int idade;  /* Novo atributo do tipo int, inserido na classe Aluno */
    String curso;
    
    /* aqui, será criado o primeiro método do tipo void, ou seja, não retorna nenhum valor de variável*/
    public void mostrarNome(){
        System.out.println("O Aluno se chama: "+nome);
    }
    
    public void descrever1(){
        System.out.println("Nome do Aluno: "+nome);
        System.out.println("Matrícula do aluno: "+matricula);
        System.out.println("CPF do aluno: "+cpf);
        System.out.println("Idade do aluno: "+idade);
        System.out.println("\n");
    }
    
    float nota1;
    float nota2;
    float media;// Aqui, é utilizado o tipo de atributo “float” para aceitar números com casas decimais 

    /* Primeiro método ainda será void apenas para mostrar os dados principais do aluno */
    public void descrever2(){
        System.out.println("Nome do Aluno: "+nome);
        System.out.println("Nota 1: "+nota1);
        System.out.println("Nota 2: "+nota2);
        System.out.println("\n");
    }

    /* método retornando um valor do tipo float, por meio do comando do recebimento de dois parâmetros */
    public float calcularMedia(float num1, float num2){
        return (num1 + num2)/2;
    }
    
    public float mostrarMaior() {
        if (nota1 >= nota2) {
            return nota1;
        } else {
            return nota2;
        }

    }

    public void mostrarResultado() {
        if (media >= 7) {
            System.out.println("O aluno foi aprovado.\n");
        } else {
            System.out.println("O aluno foi reprovado.\n");
        }
    }
    
}
