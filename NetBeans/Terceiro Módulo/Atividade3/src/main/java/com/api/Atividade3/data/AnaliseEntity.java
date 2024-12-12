package com.api.Atividade3.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@Table(name = "Analises")
public class AnaliseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "idFilme", nullable = false)
    private FilmeEntity filme;
    
    @NotBlank(message = "É obrigatório informar detalhes da análise")
    private String detalhes;
    
    @NotNull(message = "É obrigatório informar a nota do filme")
    private float nota;
}