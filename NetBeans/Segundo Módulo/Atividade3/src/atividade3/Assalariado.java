package atividade3;

public class Assalariado extends Funcionário {
    private String nomeassalariado;
    private String cpfassalariado;
    private String enderecoassalariado;
    private String telefoneassalariado;
    private String setorassalariado;
    private double salario;
    
    public Assalariado(String nomeassalariado,String cpfassalariado,String enderecoassalariado, String telefoneassalariado, String setorassalariado, double salario){
        this.nomeassalariado = nomeassalariado;
        this.cpfassalariado = cpfassalariado;
        this.enderecoassalariado = enderecoassalariado;
        this.telefoneassalariado = telefoneassalariado;
        this.setorassalariado = setorassalariado;
        this.salario = salario;
    }
    
    public String getnome(){
        return nomeassalariado;
    }
    public void setnome(String nomeassalariado){
        this.nomeassalariado = nomeassalariado;
    }
    public String getcpf(){
        return cpfassalariado;
    }
    public void setcpf(String cpfassalariado){
        this.cpfassalariado = cpfassalariado;
    }
    public String getendereco(){
        return enderecoassalariado;
    }
    public void setendereco(String enderecoassalariado){
        this.enderecoassalariado = enderecoassalariado;
    }
    public String gettelefone(){
        return telefoneassalariado;
    }
    public void settelefone(String telefoneassalariado){
        this.telefoneassalariado = telefoneassalariado;
    }
    public String getsetor(){
        return setorassalariado;
    }
    public void setsetor(String setorassalariado){
        this.setorassalariado = setorassalariado;
    }
    public double getsalario(){
        return salario;
    }
    public void setsalario(double salario){
        this.salario = salario;
    }

    
    @Override
    public void dados(){
        System.out.println("\n");
        System.out.println("Dados do funcionário(a):");
        System.out.println("Nome: "+ nomeassalariado);
        System.out.println("CPF: "+ cpfassalariado);
        System.out.println("Endereço: "+ enderecoassalariado);
        System.out.println("Telefone pra contato: "+ telefoneassalariado);
        System.out.println("Setor: "+ setorassalariado);
        System.out.println("Valor do salário: "+ salario);
    }

    @Override
    void salario() {
       double  salmensal = salario; 
       System.out.println("Salario mensal: "+ salmensal);
    }

    @Override
    void aumento(double aumento) {
        double salaumentado = getsalario() * (1 + aumento / 100.0);
        setsalario(salaumentado);
    }
}
