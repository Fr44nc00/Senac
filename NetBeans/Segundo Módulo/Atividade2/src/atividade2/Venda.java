package atividade2;

public class Venda {
    private String cliente;
    private String formadepagamento;
    private Pacotes pacotes;
    
    public Venda(String cliente, String formadepagamento, Pacotes pacotes){
        this.cliente = cliente;
        this.formadepagamento = formadepagamento;
        this.pacotes = pacotes;
    }
    public double dolarprareal(double cotacaodolar){
        double valordolar = pacotes.valorlucro(0);
        return valordolar * cotacaodolar;
    }
    
    public void dadosvenda(double cotacaodolar){
        System.out.println("Cliente: "+ cliente);
        System.out.println("Forma de pagamento: "+ formadepagamento);
        System.out.println("Destino: "+ pacotes.getdestino());
        System.out.println("Valor em dólar: "+ pacotes.valorlucro(0)+ " USD.");
        System.out.println("Valor em reais: (cotação "+cotacaodolar + "): "+ dolarprareal(cotacaodolar) + " BRL.");          
    
    }
    
}
