package atividade4;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeempresa;
    private List<Impostos> listaimpostos;
    
    public Pagamentos(String nomeempresa){
        this.nomeempresa = nomeempresa;
        this.listaimpostos = new ArrayList<>();
    }
    
    public void adicionarimposto(Impostos impostos){
        listaimpostos.add(impostos);
    }
    
    public void totalimpostos(){
        double totalIPI = 0.0;
        double totalPIS = 0.0;

       for (Impostos impostos : listaimpostos) {
            impostos.valor();
                if (impostos instanceof IPI) {
                    totalIPI += ((IPI) impostos).getvalortotal();
                } else if (impostos instanceof PIS) {
                  totalPIS += ((PIS) impostos).getvalortotal();
                }
           }       
    }
    
     public void descricaoimpostos() {
        System.out.println("Descrição dos impostos da empresa " + nomeempresa + ":");
        for (Impostos impostos : listaimpostos) {
            impostos.descrever();
        }
    }
}