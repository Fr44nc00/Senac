
package appagenciadeviagens;

public class PacoteDeViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int numDias;
    
    public PacoteDeViagem(Transporte transporte, Hospedagem hospedagem, String destino, int numDias){
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.numDias = numDias;
    }
    
    public double calcularValorLucro(double margemLucro){
        double valorTransporte = transporte.getValor();
        double valorHospedagem = hospedagem.calcularTotalHospedagem(numDias);
        double valorTotal = valorTransporte + valorHospedagem;
        return valorTotal + (valorTotal * margemLucro / 100);
    }
    
    public double calcularTotalPacote (double margemLucro, double taxasAdicionais){
        return calcularValorLucro(margemLucro) + taxasAdicionais;
    }
    
    public String getDestino(){
        return destino;
    }
    
    public double getValorTransporte(){
        return transporte.getValor();
    }
    
    public double getValorHospedagem(int numDias){
        return hospedagem.calcularTotalHospedagem(numDias);
    }
            
    
}
