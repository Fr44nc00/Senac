package atividade3;

public class Horista extends Funcionário{
    private String nomehorista;
    private String cpfhorista;
    private String enderecohorista;
    private String telefonehorista;
    private String setorhorista;
    private double horas;
    private double valorhora;

    Horista(String nomehorista, String cpfhorista, String enderecohorista, String telefonehorista, String setorhorista, double horas, double valorhora) {
        this.nomehorista = nomehorista;
        this.cpfhorista = cpfhorista;
        this.enderecohorista = enderecohorista;
        this.telefonehorista = telefonehorista;
        this.setorhorista = setorhorista;
        this.horas = horas;
        this.valorhora = valorhora;
    }

    public String getnome() {
        return nomehorista;
    }
    public void setnome(String nomehorista) {
        this.nomehorista = nomehorista;
    }
    public String getcpf() {
        return cpfhorista;
    }
    public void setcpf(String cpfhorista) {
        this.cpfhorista = cpfhorista;
    }
    public String getendereco() {
        return enderecohorista;
    }
    public void setendereco(String enderecohorista) {
        this.enderecohorista = enderecohorista;
    }
    public String gettelefone() {
        return telefonehorista;
    }
    public void settelefone(String telefonehorista) {
        this.telefonehorista = telefonehorista;
    }
    public String getsetor() {
        return setorhorista;
    }
    public void setsetor(String setorhorista) {
        this.setorhorista = setorhorista;
    }
    public double gethoras() {
        return horas;
    }
    public void sethoras(double horas) {
        this.horas = horas;
    }
    public double getvalorhora() {
        return valorhora;
    }
    public void setvalorhora(double valorhora) {
        this.valorhora = valorhora;
    }
    
    
    @Override
    public void dados(){
        System.out.println("\n");
        System.out.println("Dados do funcionário(a): ");
        System.out.println("Nome: "+ nomehorista);
        System.out.println("CPF: "+ cpfhorista);
        System.out.println("Endereço: "+ enderecohorista);
        System.out.println("Telefone pra contato: "+ telefonehorista);
        System.out.println("Setor: "+ setorhorista );
        System.out.println("Horas de trabalho: "+ horas);
        System.out.println("Valor por hora: "+ valorhora);
    }
    
    @Override
    void salario() {
        double resultado = horas * valorhora;
        System.out.println("Valor a ser recebido: "+ resultado);
    }

    @Override
    void aumento(double aumento) {
        double horaaumentada = getvalorhora() * (1 + aumento / 100.0);
        setvalorhora(horaaumentada);
    }
}
