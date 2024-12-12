package atividade2;

public class Pacotes {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int dias;
    
    public Pacotes(Transporte transporte, Hospedagem hospedagem, String destino, int dias){
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.dias = dias;
    }
    
    public double valorlucro(double margemlucro){
        double valortransporte = transporte.getvalor();
        double valorhospedagem = hospedagem.totalhospedagem(dias);
        double valortotal = valortransporte + valorhospedagem;
        return valortotal + (valortotal * margemlucro / 100);
    }
    
    public double totalpacote (double margemlucro, double taxasadicionais){
        return valorlucro(margemlucro) + taxasadicionais;
    }
    
    public String getdestino(){
        return destino;
    }
    
    public double getvalortransporte(){
        return transporte.getvalor();
    }
    
    public double getvalorhospedagem(int dias){
        return hospedagem.totalhospedagem(dias);
    }
            
     
}
