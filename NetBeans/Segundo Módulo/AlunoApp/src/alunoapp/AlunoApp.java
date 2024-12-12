package alunoapp;

public class AlunoApp {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        /* Aqui é instanciado o primeiro objeto chamado aluno1, por meio do uso da palavra reservada new */
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();
        /*Aqui são instanciados três objetos da mesma classe aluno, e agora é possível decidir qual atributo se quer utilizar para cada um deles */

        aluno1.nome = "Celso Medeiros";
        /* Aqui é colocado o valor “Celso Morais” no atributo nome do aluno1 */
        aluno1.matricula = 1;
        /* Aqui é colocado o valor “1” no atributo matrícula do aluno1 */
        aluno1.cpf = "00134578090";
        /* Aqui é colocado o valor “0013457890” no atributo cpf do aluno1 */
        aluno1.idade = 23;
        aluno1.nota1=(float) 9.7;
        aluno1.nota2=(float) 6.5;

        aluno2.nome = "Camila Alves";
        aluno2.matricula = 2;
        aluno2.cpf = "00534578119";
        aluno2.idade = 32;
        aluno2.nota1=(float) 4.2;
        aluno2.nota2=(float) 6.5;

        aluno3.nome = "Joana Carneiro";
        aluno3.matricula = 3;
        aluno3.cpf = "0019007890";
        aluno3.idade = 17;
        /* Logo abaixo, será utilizado o comando System.out.println, que é usado para mostrar uma informação na tela do usuário */
        
        /*Criados os objetos, deve-se mostrar os resultados na tela */
            
        System.out.println("Mostrar Alunos:");
        aluno1.mostrarNome(); /* chamando o método criado */
        
        System.out.println("Mostrar Alunos:/n"); /*o comando \n serve para pular uma linha após o mostrar alunos */

        System.out.println("Nome do aluno1: " + aluno1.nome);
        System.out.println("Matrícula do aluno1: " + aluno1.matricula);
        System.out.println("CPF do aluno1: " + aluno1.cpf);

        System.out.println("/n"); /*o comando \n aqui também pula uma linha, mesmo colocado sozinho dentro do comando System.out.println */

        System.out.println("Nome do aluno2: " + aluno2.nome);
        System.out.println("Matrícula do aluno2: " + aluno2.matricula);

        System.out.println("/n");
        System.out.println("CPF do aluno3: " + aluno3.cpf);
        
        System.out.println("Mostrar Alunos:\n");
        /* Chamada da classe descrever() */
        aluno1.descrever1(); 

        /* Uma linha de código evita a escrita neste caso de quatro linhas que são:
        System.out.println("Nome do aluno1: " + aluno1.nome);
        System.out.println("Matrícula do aluno1: " + aluno1.matricula);
        System.out.println("CPF do aluno1: " + aluno1.cpf);
        System.out.println("Idade do aluno1: " + aluno1.idade);
        */

        aluno2.descrever1();
        aluno3.descrever1();
        
        System.out.println("Mostrar Alunos:\n");

        aluno1.descrever2();
        System.out.println("A média do aluno é: "+aluno1.calcularMedia(aluno1.nota1, aluno1.nota2));

        System.out.println("A maior nota do aluno é: "+aluno1.mostrarMaior());
        aluno1.mostrarResultado();

        aluno2.descrever2();
        System.out.println("A média do aluno é: "+aluno2.calcularMedia(aluno1.nota1, aluno1.nota2));

        System.out.println("A maior nota do aluno é: "+aluno2.mostrarMaior());
        aluno2.mostrarResultado();
        
        /*Para instanciar 40 objetos, você teria que utilizar os seguintes comandos:

              
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();
        Aluno aluno4 = new Aluno();

        E assim sucessivamente até:
        .
        .
        .
        Aluno aluno40 = new Aluno(); */
        
        /* na próxima linha, cria-se um vetor de objeto com 40 posições do tipo Aluno, ou seja, que utiliza a classe como guia e pode ter todos os seus atributos utilizados, tais como nome, nota1, nota2 e média, e também a possibilidade de utilização de todos os seus métodos  */
        Aluno[] aluno = new Aluno[40];
        int i;

        /* o índice do vetor vai de 0 a 39, o que permite a inserção de 40 objetos, desde o objeto aluno[0] até o aluno[39] */
        for(i = 0; i<=39; i++){
        aluno[i] = new Aluno();
    }

    /* para mostrar que essa forma de instância de vários objetos funciona, armazene nome em três objetos diferentes */
    aluno[0].nome="Maria";
    aluno[0].descrever1();

    aluno[20].nome="José";
    aluno[20].descrever1();

    aluno[39].nome="Josi";
    aluno[39].descrever1();
    }
    
    /* o método main é o método principal, necessário para que sua aplicação Java funcione; se ele não for declarado, já aparecerá um erro e seus objetos não serão criados */

        Aluno2 aluno1 = new Aluno("João da Silva",001,"TDS");
        Aluno2 aluno2 = new Aluno("Jorge Aguiar",002,"TDS");
        Aluno2 aluno3 = new Aluno("Camila Santos",003,"TDS");
    }
    
    
}
