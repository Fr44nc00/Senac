package com.api.Catalogo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "Filmes")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "É obrigatório informar o título do filme")
    private String titulo;
    
    @NotBlank(message = "É obrigatório informar a sinopse do filme")
    private String sinopse;
    
    @NotBlank(message = "É obrigatório informar o gênero do filme")
    private String genero;

    @Min(value = 1800, message = "Ano inválido: deve ser maior ou igual a 1800")
    @NotNull(message = "É obrigatório informar o ano em que o filme foi lançado.")
    private Integer anoLancamento;
}