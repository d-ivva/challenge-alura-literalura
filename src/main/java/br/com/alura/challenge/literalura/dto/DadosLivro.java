package br.com.alura.challenge.literalura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
    
    Long id,
    @JsonAlias("authors") List<DadosAutor> autor,
    @JsonAlias("title") String titulo,
    @JsonAlias("languages") List<String> idioma

) {

}
