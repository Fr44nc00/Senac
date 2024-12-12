
package meurh;

public class FuncionarioAssalariado extends Funcionario {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String setor;
    private double salario;
    
    public FuncionarioAssalariado(String nome,String cpf,String endereco, String telefone, String setor, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getSetor(){
        return setor;
    }
    public void setSetor(String setor){
        this.setor = setor;
    }
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }

    
    @Override
    public void mostrarDados(){
        System.out.println("\n");
        System.out.println("--DADOS DO FUNCIONÁRIO(A)--");
        System.out.println("NOME: "+ nome);
        System.out.println("CPF: "+ cpf);
        System.out.println("ENDEREÇO: "+ endereco);
        System.out.println("CONTATO: "+ telefone);
        System.out.println("SETOR: "+ setor );
        System.out.println("SALÁRIO: "+ salario);
    }

    @Override
    void calcularSalario() {
       double  salarioMensal = salario; 
       System.out.println("SALÁRIO MENSAL: "+ salarioMensal);
    }

    @Override
    void aumentarSalario(double aumento) {
        double salarioAumentado = getSalario() * (1 + aumento / 100.0);
        setSalario(salarioAumentado);
    }
}
