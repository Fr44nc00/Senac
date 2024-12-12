package testetv;

import java.util.Scanner;

public class TesteTV {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String operacao = "";
        byte canal;
        short volume;

        Televisor minhaTV = new Televisor();//instanciando o objeto Televisor
        do
        {
            minhaTV.display();
            System.out.println("Digite a operação da TV: [L]igar; [D]esligar; [T]rocar canal; [+]Aumentar volume; [-]Diminuir volume; [X]Sair");
            operacao = entrada.nextLine();

            switch(operacao)
            {
                case "L":
                    minhaTV.ligar();
                    break;
                case "D":
                    minhaTV.desligar();
                    break;
                case "T":
                    System.out.print("Digite o canal desejado (entre 2 e 13): ");
                    canal = entrada.nextByte();
                    entrada.nextLine(); //consumir o [enter] digitado após o número
                    minhaTV.trocarCanal(canal);
                    break;
                case "+":
                    minhaTV.aumentarVolume();
                    break;
                case "-":
                    minhaTV.diminuirVolume();
                    break;
                case "X":
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(!operacao.equals("X"));
    }

}
