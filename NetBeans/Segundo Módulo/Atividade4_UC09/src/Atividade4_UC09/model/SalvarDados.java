package Atividade4_UC09.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SalvarDados {

    public static void salvarComoCSV(List<String[]> dados, String caminhoArquivo, boolean adicionarAoFinal) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, adicionarAoFinal))) {
            for (String[] linha : dados) {
               String linhaCSV = String.join(",", linha);
                writer.write(linhaCSV);
                writer.newLine(); // Adiciona uma nova linha
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
