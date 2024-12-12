package atividadejanelas4.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Salvamento {

    public static void salvarCSV(List<String[]> dados, String caminho, boolean adicionarnofim) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho, adicionarnofim))) {
            for (String[] linha : dados) {
               String linhasCSV = String.join(",", linha);
                escritor.write(linhasCSV);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
