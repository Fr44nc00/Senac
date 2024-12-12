/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author RaquelNunes
 */
public class Paciente {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String dataConsulta;
    private boolean isPaciente;
    private boolean consultaRealizada;
    private String observacoes;
    
    public Paciente() {
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public boolean isIsPaciente() {
        return isPaciente;
    }

    public void setIsPaciente(boolean isPaciente) {
        this.isPaciente = isPaciente;
    }
    
    /*public void getIsPaciente(boolean isPaciente) {
        this.isPaciente = isPaciente;
    }*/

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }
    
    /*public void getConsultaRealizada(boolean consultaRealizada) {
    this.consultaRealizada = consultaRealizada;
    }*/

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

 }

