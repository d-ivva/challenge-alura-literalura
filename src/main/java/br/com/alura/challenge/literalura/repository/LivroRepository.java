package br.com.alura.challenge.literalura.repository;

import br.com.alura.challenge.literalura.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}