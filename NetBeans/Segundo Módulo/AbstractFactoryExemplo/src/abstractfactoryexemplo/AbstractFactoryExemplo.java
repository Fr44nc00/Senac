package abstractfactoryexemplo;

import java.util.Scanner;

public class AbstractFactoryExemplo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe 1-Games Antigos ou 2-Games novos");
        int opc = sc.nextInt();

        Modelo modelo = null;
        switch (opc) {
            case 1:
                modelo = new FabricaAntigos();
                break;
            case 2:
                modelo = new FabricaNovos();
                break;
        }

        SugestaoGame sugestao = new SugestaoGame(modelo);
        sugestao.gerar();

        System.out.println("Esportes: " + sugestao.getGameEsporte().toString());
        System.out.println("RPG: " + sugestao.getGameRPG().toString());
    }
}