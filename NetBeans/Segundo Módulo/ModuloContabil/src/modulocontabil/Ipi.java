
package modulocontabil;

public class Ipi implements Imposto {
    private double aliquota;
    private double valorProduto;
    private double frete;
    private double seguro;
    private double outrasDespesas;
    private double baseDeCalculo;
 
    
    public Ipi(double aliquota, double valorProduto, double frete,double seguro,double outrasDespesas,double baseDeCalculo){
        this.aliquota = aliquota;
        this.valorProduto = valorProduto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasDespesas = outrasDespesas;
        this.baseDeCalculo = baseDeCalculo;
       
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }
    
    public double getBaseDeCalculo() {
        return baseDeCalculo;
    }

    public void setBaseDeCalculo(double baseDeCalculo) {
        this.baseDeCalculo = baseDeCalculo;
    }


    @Override
    public void calcularValor() {
       baseDeCalculo = (valorProduto + frete + seguro + outrasDespesas)* aliquota / 100;        
    }
    
    public double getValorTotal(){
       return baseDeCalculo;
    }

    @Override
    public void descrever() {
       System.out.println("\n--DEMONSTRATIVO DE VALORES DO IPI--");
       System.out.println("VALOR DO PRODUTO: R$ "+ valorProduto);
       System.out.println("FRETE: R$ "+ frete);
       System.out.println("SEGURO R$ "+ seguro);
       System.out.println("OUTRAS DESPESAS: R$ "+ outrasDespesas);
       System.out.println("ALÍQUOTA: R$ "+ aliquota);
       System.out.println("VALOR A PAGAR: R$ "+ baseDeCalculo);   
    }
    
}
