
package modulocontabil;

public class Pis implements Imposto {
    private double credito;
    private double debito;
    private double total;
    
    public Pis(double credito,double debito,double total){
        this.credito = credito;
        this.debito = debito;
        this.total = total;
    }

    Pis(double credito, double debito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public void calcularValor() {
        total = (credito - debito)*1.65 / 100 ;
    }
    
     public double getValorTotal(){
       return total;
    }

    @Override
    public void descrever() {
        System.out.println("\n--DEMONSTRATIVO DE VALORES PIS--");
        System.out.println("CREDITO: R$ "+ credito);
        System.out.println("DÉBITO: R$ "+ debito);
        System.out.println("TOTAL: R$ "+ total);
    }
    
}
