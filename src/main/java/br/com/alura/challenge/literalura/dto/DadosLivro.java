package br.com.alura.challenge.literalura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
    
    Long id,
    @JsonAlias("authors") List<DadosAutor> autor,
    @JsonAlias("title") String titulo,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count") Double numeroDownloads

) {

    @Override
    public String toString() {
        String nomeAutor = autor.isEmpty() ? "Autor desconhecido" : autor.get(0).nome();
        return """
            \n
            Título: %s
            Autor (es): %s
            Idioma: %s
            Downloads: %.0f
            """.formatted(titulo, nomeAutor, idioma.get(0), numeroDownloads);
    }

}
