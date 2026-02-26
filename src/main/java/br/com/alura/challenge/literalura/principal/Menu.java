package br.com.alura.challenge.literalura.principal;

import java.util.Optional;
import java.util.Scanner;

import br.com.alura.challenge.literalura.domain.Autor;
import br.com.alura.challenge.literalura.domain.Livro;
import br.com.alura.challenge.literalura.dto.DadosAutor;
import br.com.alura.challenge.literalura.dto.DadosLivro;
import br.com.alura.challenge.literalura.dto.DadosResultado;
import br.com.alura.challenge.literalura.repository.AutorRepository;
import br.com.alura.challenge.literalura.repository.LivroRepository;
import br.com.alura.challenge.literalura.service.ConsumoApi;
import br.com.alura.challenge.literalura.service.ConverteDados;

public class Menu {
    private Scanner entrada = new Scanner(System.in);
    private int opcao;

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private AutorRepository autorRepository;
    private LivroRepository livroRepository;

    public Menu(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibirMenu() throws Exception {
        String menu = """
                \n*** CATÁLOGO DE LIVROS ***
                1. Buscar livro pelo título
                2. Listar livros cadastrados
                3. Listar autores cadastrados
                4. Listar autores em determinado ano
                5. Listar livros em determinado idioma

                0. Sair

                Escolha a opção desejada:
                """;
        opcao = -1;
        
        while (opcao != 0) {
            System.out.print(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Insira o título do livro: ");
                    String tituloLivro = entrada.nextLine();
                    buscarLivro(tituloLivro);
                    break;
                case 2:
                    listarTodosLivros();
                    break;
                case 3:
                    listarTodosAutores();
                    break;
                case 4:
                    System.out.println("Insira o ano desejado para busca: ");
                    int ano = entrada.nextInt();
                    listarAutoresNoAno(ano);
                    break;
                case 5:
                    System.out.println("Insira o idioma desejado: ");
                    String idioma = entrada.nextLine();
                    buscarLivrosIdioma(idioma);
                    break;
                case 0:
                    System.out.println("Até a próxima! Encerrando o sistema...");
                    entrada.close();
                    break;
                default:
                System.out.println("Opção inválida. Tente novamente!");
                break;
            }
        }
    }

private void buscarLivro(String tituloLivro) {
        String endereco = "https://gutendex.com/books?search=" + tituloLivro.trim().replace(" ", "%20");
        
        try {
            String jsonResultadoBusca = consumoApi.obterDados(endereco);
            DadosResultado dados = conversor.converterDados(jsonResultadoBusca, DadosResultado.class);
            
            if (dados.resultadosBusca().isEmpty()) {
                System.out.println("Poxa, não identificamos esse título na Gutendex.");
                return; 
            }
            
            DadosLivro dadosLivro = dados.resultadosBusca().get(0);
            DadosAutor dadosAutor = dadosLivro.autor().get(0);
            
            Optional<Autor> autorBuscado = autorRepository.findByNomeIgnoreCase(dadosAutor.nome());
            
            Autor autor;
            if (autorBuscado.isPresent()) {
                autor = autorBuscado.get();
            } else {
                Autor novoAutor = new Autor(dadosAutor);
                autor = autorRepository.save(novoAutor);
            }
            
            Livro livro = new Livro(dadosLivro, autor);
  
            livroRepository.save(livro);
            System.out.println(dadosLivro); 
            
        } catch (Exception e) {
            System.out.println("Ops! Aconteceu um erro inesperado: " + e.getMessage());
        }
    }

    private void listarTodosLivros() {
        var livros = livroRepository.findAll();

        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livros) {
                System.out.printf("Título: %s | Autor: %s | Idioma: %s\n", 
                        livro.getTitulo(), 
                        livro.getAutor().getNome(), 
                        livro.getIdioma());
            }
        }
    }

    private void listarTodosAutores() {
        var autores = autorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("Não há autores cadastrados.");
        } else {
            for (Autor autor : autores) {
                System.out.printf("Nome: %s | Nascimento: %s | Falecimento: %s\n", 
                        autor.getNome(), 
                        autor.getAnoNascimento(), 
                        autor.getAnoFalecimento());
            }
        }
    }

    private void listarAutoresNoAno(int ano) {
       
    }

    private void buscarLivrosIdioma(String idioma) {
        
    }

}
