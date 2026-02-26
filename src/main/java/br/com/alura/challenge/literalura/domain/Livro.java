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

    public Livro(){

    }

    public Livro(DadosLivro dados, Autor autor){
        this.autor = autor;
        this.titulo = dados.titulo();
       this.idioma = dados.idioma().isEmpty() ? "Desconhecido" : dados.idioma().get(0);
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

}
