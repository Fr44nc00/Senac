public class Cadastros {
    
    private String nome, cpf, telefone;
    private String data, erapaciente, consreal = "não";
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEraPaciente() {
        return erapaciente;
    }

    public void setEraPaciente(String erapaciente) {
        this.erapaciente = erapaciente;
    }

    public String getConsReal() {
        return consreal;
    }

    public void setConsReal(String consreal) {
        this.consreal = consreal;
    }
    
}
