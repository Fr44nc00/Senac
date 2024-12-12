package AtividadeJanelas3.model;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    private static final List<Cadastros> cadastrosList = new ArrayList<>();
    
    public static List<Cadastros> ListarCadastros(){
        return cadastrosList;
    }

    public static void AdicionarCadastros(Cadastros cadastro){
        cadastrosList.add(cadastro);
    }

}
