package br.com.alura.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(

    @JsonAlias("name") String nome,
    @JsonAlias("birth_year") Integer anoNascimento,
    @JsonAlias("death_year") Integer anoFalecimento
) {

    @Override
    public String toString() {
        return """
                Nome: %s
                Ano de Nascimento: %s
                Ano de Falecimento: %s
                """.formatted(nome, anoNascimento, anoFalecimento);
    }
}
