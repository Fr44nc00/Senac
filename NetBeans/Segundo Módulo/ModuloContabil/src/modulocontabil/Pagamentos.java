
package modulocontabil;
import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> listaDeImpostos;
    
    public Pagamentos(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
        this.listaDeImpostos = new ArrayList<>();
    }
    
    public void adicionarImposto(Imposto imposto){
        listaDeImpostos.add(imposto);
    }
    
    public void calcularTotalImpostos(){
        double totalIpi = 0.0;
        double totalPis = 0.0;

       for (Imposto imposto : listaDeImpostos) {
            imposto.calcularValor();
                if (imposto instanceof Ipi) {
                    totalIpi += ((Ipi) imposto).getValorTotal();
                } else if (imposto instanceof Pis) {
                  totalPis += ((Pis) imposto).getValorTotal();
                }
           }       
    }
    
     public void exibirDescricaoImpostos() {
        System.out.println("\n--DESCRIÇÃO DOS IMPOSTOS PARA " + nomeEmpresa + "--");
        for (Imposto imposto : listaDeImpostos) {
            imposto.descrever();
        }
    }
}
