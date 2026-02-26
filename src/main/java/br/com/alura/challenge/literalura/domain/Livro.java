package br.com.alura.challenge.literalura.domain;

import br.com.alura.challenge.literalura.dto.DadosLivro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Autor autor;

    @Column(unique = true, nullable = false)
    private String titulo;
    private String idioma;
    private Double numeroDownloads;

    public Livro(){

    }

    public Livro(DadosLivro dados, Autor autor){
        this.autor = autor;
        this.titulo = dados.titulo();
        this.idioma = dados.idioma().isEmpty() ? "Desconhecido" : dados.idioma().get(0);
        this.numeroDownloads = dados.numeroDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return """
                ----- LIVRO -----
                Título: %s
                Autor: %s
                Idioma: %s
                Downloads: %.0f
                -----------------
                """.formatted(titulo, autor.getNome(), idioma, numeroDownloads);
    }

}
