package br.com.alura.challenge.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.challenge.literalura.principal.Menu;
import br.com.alura.challenge.literalura.repository.AutorRepository;
import br.com.alura.challenge.literalura.repository.LivroRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

    public void run(String... args) throws Exception {
       Menu menu = new Menu(livroRepository, autorRepository);
	   menu.exibirMenu();
    }

}
