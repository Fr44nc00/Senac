package atividade4;

public class PIS implements Impostos {
    private double credito;
    private double debito;
    private double total;
    
    public PIS(double credito,double debito,double total){
        this.credito = credito;
        this.debito = debito;
        this.total = total;
    }

    public double getcredito() {
        return credito;
    }

    public void setcredito(double credito) {
        this.credito = credito;
    }

    public double getdebito() {
        return debito;
    }

    public void setdebito(double debito) {
        this.debito = debito;
    }

    public double gettotal() {
        return total;
    }

    public void settotal(double total) {
        this.total = total;
    }

    @Override
    public void valor() {
        total = (credito - debito)*(1.65 / 100) ;
    }
    
    public double getvalortotal(){
       return total;
    }

    @Override
    public void descrever() {
        System.out.println("\nValores do PIS");
        System.out.println("Crédito: R$ "+ credito);
        System.out.println("Débito: R$ "+ debito);
        System.out.println("Total: R$ "+ total);
    }
    
}