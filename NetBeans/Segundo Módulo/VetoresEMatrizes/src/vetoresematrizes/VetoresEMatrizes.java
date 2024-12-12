package vetoresematrizes;

import java.util.Scanner;

public class VetoresEMatrizes {

    public static void main(String[] args) {
        int [] numeros = new int [10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = (int) (Math.random() * 100);
            System.out.println("Número: " + numeros[i]);
        }
        
        //
        
        String[] semana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };
        System.out.println("Dias da Semana:");
        for (int i = 0; i < semana.length; i++) {
            System.out.println(semana[i]);

        }
        
        //
        
        Scanner entrada = new Scanner(System.in);
        
        int qtdeAlunos, qtdeAcimaMedia;
        float soma, media;
        
        System.out.println("Quantos alunos serão informados?");
        qtdeAlunos = entrada.nextInt();
        
        //declarando o vetor usando o valor da variável qtdeAlunos para a quantidade de elementos
        float[] notas = new float[qtdeAlunos];
        soma = 0;
        
        //vetor.length é uma propriedade que traz o número de elementos de um vetor
        for(int i = 0; i < notas.length; i++)
        {
            System.out.println("Digite a nota " + (i+1) + ": ");
            notas[i] = entrada.nextFloat();
            soma += notas[i];
        }
        
        //calculando a média a partir do somatório obtido no laço anterior
        media = soma / qtdeAlunos;
        System.out.println("Média " + media);
        
        qtdeAcimaMedia = 0;
                
        for(int i = 0; i < notas.length; i++)
        {
            if(notas[i] > media)
            {
                System.out.println("Nota " + notas[i] + " acima da média.");
                qtdeAcimaMedia++;
            }
        }
        
        System.out.println("Foram no total " + qtdeAcimaMedia + " notas acima da média");
        
        // Exemplo de como mostrar matriz
        
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Percorra as linhas da matriz
        for (int i = 0; i < matriz.length; i++) {
            // Percorra as colunas da matriz
            for (int j = 0; j < matriz[i].length; j++) {
                // Imprima o elemento na posição i, j
                System.out.print(matriz[i][j] + " ");
            }
            // Pule para a próxima linha após cada linha da matriz
            System.out.println();
        }
    }
    
}
