package com.senac.Atividade1.model;

public class Analise {
    private int id;
    private int idFilme;
    private String detalhes;
    private float nota;
    
    public Analise(){}
    
    public Analise(int id, int idFilme, String detalhes, float nota){
        this.id = id;
        this.idFilme = idFilme;
        this.detalhes = detalhes;
        this.nota = nota;
    }
    
    public int getId() { return id; } 
    public void setId(int id) { this.id = id; }
    public int getIdFilme() { return idFilme; } 
    public void setIdFilme(int idFilme) { this.idFilme = idFilme; }
    public String getDetalhes() { return detalhes; } 
    public void setDetalhes(String detalhes) { this.detalhes = detalhes; }
    public float getNota() { return nota; } 
    public void setNota(float nota) { this.nota = nota; }
}
