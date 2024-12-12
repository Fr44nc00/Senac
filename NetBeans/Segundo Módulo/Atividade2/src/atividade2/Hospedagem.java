package atividade2;

public class Hospedagem {
    private String descricao;
    private double diaria;
    
    public Hospedagem(String descricao, double diaria){
        this.descricao = descricao;
        this.diaria = diaria;
    }
    public double totalhospedagem(int dias){
        return diaria * dias;
    }
}
