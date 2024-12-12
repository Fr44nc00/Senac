
package meurh;

public class FuncionarioHorista extends Funcionario {
    private String nomeHorista;
    private String cpfHorista;
    private String enderecoHorista;
    private String telefoneHorista;
    private String setorHorista;
    private double horas;
    private double valorHora;

    FuncionarioHorista(String nomeHorista, String cpfHorista, String enderecoHorista, String telefoneHorista, String setorHorista, double horas, double valorHora) {
        this.nomeHorista = nomeHorista;
        this.cpfHorista = cpfHorista;
        this.enderecoHorista = enderecoHorista;
        this.telefoneHorista = telefoneHorista;
        this.setorHorista = setorHorista;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nomeHorista;
    }

    public void setNome(String nomeHorista) {
        this.nomeHorista = nomeHorista;
    }

    public String getCpf() {
        return cpfHorista;
    }

    public void setCpf(String cpfHorista) {
        this.cpfHorista = cpfHorista;
    }

    public String getEndereco() {
        return enderecoHorista;
    }

    public void setEndereco(String enderecoHorista) {
        this.enderecoHorista = enderecoHorista;
    }

    public String getTelefone() {
        return telefoneHorista;
    }

    public void setTelefone(String telefoneHorista) {
        this.telefoneHorista = telefoneHorista;
    }

    public String getSetor() {
        return setorHorista;
    }

    public void setSetor(String setorHorista) {
        this.setorHorista = setorHorista;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    
    
    
    @Override
    public void mostrarDados(){
        System.out.println("\n");
        System.out.println("--DADOS DO FUNCIONÁRIO(A)--");
        System.out.println("NOME: "+ nomeHorista);
        System.out.println("CPF: "+ cpfHorista);
        System.out.println("ENDEREÇO: "+ enderecoHorista);
        System.out.println("CONTATO: "+ telefoneHorista);
        System.out.println("SETOR: "+ setorHorista );
        System.out.println("HORAS TRABALHADAS: "+ horas);
        System.out.println("VALOR DA HORA: "+ valorHora);
    }
    
    @Override
    void calcularSalario() {
        double resultado = horas * valorHora;
        System.out.println("VALOR A RECEBER: "+ resultado);
    }

    @Override
    void aumentarSalario(double aumento) {
        double horaAumentado = getValorHora() * (1 + aumento / 100.0);
        setValorHora(horaAumentado);
    }
}

