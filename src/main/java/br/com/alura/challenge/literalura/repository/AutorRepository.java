package br.com.alura.challenge.literalura.repository;

import br.com.alura.challenge.literalura.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}