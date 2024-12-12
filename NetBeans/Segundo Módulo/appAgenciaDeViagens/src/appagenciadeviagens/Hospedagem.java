
package appagenciadeviagens;

public class Hospedagem {
    private String descricao;
    private double valorDiaria;
    
    public Hospedagem(String descricao, double valorDiaria){
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }
    public double calcularTotalHospedagem(int numDias){
        return valorDiaria * numDias;
    }
}
