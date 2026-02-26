package br.com.alura.challenge.literalura.repository;

import br.com.alura.challenge.literalura.domain.Livro;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
    List<Livro> findAllByOrderByTituloAsc();

    List<Livro> findByIdioma(String idioma);

    Optional<Livro> findByTituloIgnoreCase(String titulo);
}