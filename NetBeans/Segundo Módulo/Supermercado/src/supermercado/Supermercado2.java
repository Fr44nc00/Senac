/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;

/**
 *
 * @author venec
 */

import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoController cp = new ProdutoController();
        
        while (true) {
            System.out.println("Cadastro de Produto");
            System.out.print("Digite o ID do produto (ou -1 para sair): ");
            int id = scanner.nextInt();
            if (id == -1) {
                break;
            }

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.next();

            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();

            ProdutoEntity produto = new ProdutoEntity();
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);

            if (cp.salvarProduto(produto)){
                System.out.println("Produto salvo com sucesso");
            } else {
                System.out.println("Erro ao salvar produto");
            }

            System.out.println("Deseja cadastrar outro produto? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}

