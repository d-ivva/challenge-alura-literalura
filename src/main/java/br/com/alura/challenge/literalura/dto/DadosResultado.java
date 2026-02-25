package br.com.alura.challenge.literalura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResultado(
    
    @JsonAlias("results") List<DadosLivro> resultadosBusca

) {

}
