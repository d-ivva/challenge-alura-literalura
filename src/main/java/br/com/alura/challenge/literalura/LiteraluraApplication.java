package br.com.alura.challenge.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.challenge.literalura.dto.DadosResultado;
import br.com.alura.challenge.literalura.service.ConsumoApi;
import br.com.alura.challenge.literalura.service.ConverteDados;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	//teste
    public void run(String... args) throws Exception {
        ConsumoApi consumoApi = new ConsumoApi();
        String urlBusca = "https://gutendex.com/books?search=dom+casmurro";
        String json = consumoApi.obterDados(urlBusca);
        System.out.println("Retorno da API:");
        System.out.println(json);
        
        
        ConverteDados conversor = new ConverteDados();
        DadosResultado dados = conversor.obterDados(json, DadosResultado.class);
        System.out.println("Dados convertidos:");
        System.out.println(dados);
    }

}
