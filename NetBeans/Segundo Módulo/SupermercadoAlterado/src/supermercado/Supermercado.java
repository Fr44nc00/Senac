package supermercado;

import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoController cp = new ProdutoController();
        
        while (true) {
            System.out.println("Cadastro de Produto");
            System.out.print("---Sistema de cadastro de produtos---\nInsira o ID do produto: ");
            int id = scanner.nextInt();

            System.out.print("Insira o nome do produto: ");
            String nome = scanner.next();

            System.out.print("Insira o preço do produto: ");
            double preco = scanner.nextDouble();

            ProdutoEntity produto = new ProdutoEntity();
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);

            if (cp.salvarproduto(produto)){
                System.out.println("Produto salvo com sucesso");
            } else {
                System.out.println("Erro ao salvar produto");
            }

            System.out.println("Deseja cadastrar outro produto?\nSim (S) Não (N):");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}