package br.com.alura.challenge.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.challenge.literalura.principal.Menu;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

    public void run(String... args) throws Exception {
       Menu menu = new Menu();
	   menu.exibirMenu();
    }

}
