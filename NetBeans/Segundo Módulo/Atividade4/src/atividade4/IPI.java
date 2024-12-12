package atividade4;

public class IPI implements Impostos {
    private double aliquota;
    private double valorproduto;
    private double frete;
    private double seguro;
    private double outrasdespesas;
    private double basecalculo;
 
    
    public IPI(double aliquota, double valorproduto, double frete,double seguro,double outrasdespesas,double basecalculo){
        this.aliquota = aliquota;
        this.valorproduto = valorproduto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasdespesas = outrasdespesas;
        this.basecalculo = basecalculo;
       
    }

    public double getaliquota() {
        return aliquota;
    }

    public void setaliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getvalorproduto() {
        return valorproduto;
    }

    public void setvalorproduto(double valorproduto) {
        this.valorproduto = valorproduto;
    }

    public double getfrete() {
        return frete;
    }

    public void setfrete(double frete) {
        this.frete = frete;
    }

    public double getseguro() {
        return seguro;
    }

    public void setseguro(double seguro) {
        this.seguro = seguro;
    }

    public double getoutrasdespesas() {
        return outrasdespesas;
    }

    public void setoutrasdespesas(double outrasdespesas) {
        this.outrasdespesas = outrasdespesas;
    }
    
    public double getbasecalculo() {
        return basecalculo;
    }

    public void setbasecalculo(double basecalculo) {
        this.basecalculo = basecalculo;
    }


    @Override
    public void valor() {
       basecalculo = (valorproduto + frete + seguro + outrasdespesas)* aliquota / 100;        
    }
    
    public double getvalortotal(){
       return basecalculo;
    }

    @Override
    public void descrever() {
       System.out.println("\nValores do IPI");
       System.out.println("Valor do produto: R$ "+ valorproduto);
       System.out.println("Frete: R$ "+ frete);
       System.out.println("Seguro: R$ "+ seguro);
       System.out.println("Outras despesas: R$ "+ outrasdespesas);
       System.out.println("Alíquota: R$ "+ aliquota);
       System.out.println("Valor a ser pago: R$ "+ basecalculo);   
    }
    
}