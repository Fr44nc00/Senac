
package appagenciadeviagens;

public class Venda {
    private String cliente;
    private String formaDePagamento;
    private PacoteDeViagem pacoteDeViagem;
    
    public Venda(String cliente, String formaDePagamento, PacoteDeViagem pacoteDeViagem){
        this.cliente = cliente;
        this.formaDePagamento = formaDePagamento;
        this.pacoteDeViagem = pacoteDeViagem;
    }
    public double converterDolarParaReal(double cotacaoDolar){
        double valorTotalDolar = pacoteDeViagem.calcularValorLucro(0);
        return valorTotalDolar * cotacaoDolar;
    }
    
    public void mostrarDadosVenda(double cotacaoDolar){
        System.out.println("Cliente: "+ cliente);
        System.out.println("Forma de pagamento: "+ formaDePagamento);
        System.out.println("Destino: "+ pacoteDeViagem.getDestino());
        System.out.println("Valor em Dólar: "+ pacoteDeViagem.calcularValorLucro(0)+ " USD.");
        System.out.println("Valor em Reais: (cotação "+cotacaoDolar + "): "+ converterDolarParaReal(cotacaoDolar) + " BRL.");          
    
    }
    
}
