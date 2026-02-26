package br.com.alura.challenge.literalura.principal;

import java.io.IOException;
import java.util.Scanner;

import br.com.alura.challenge.literalura.dto.DadosLivro;
import br.com.alura.challenge.literalura.dto.DadosResultado;
import br.com.alura.challenge.literalura.service.ConsumoApi;
import br.com.alura.challenge.literalura.service.ConverteDados;

public class Menu {
    private Scanner entrada = new Scanner(System.in);
    private int opcao;
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

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

    private void buscarLivro(String tituloLivro) throws Exception {
        String endereco = "https://gutendex.com/books?search=" + tituloLivro.trim().replace(" ", "%20");
        try {
            String jsonlivroBuscado = consumoApi.obterDados(endereco);
            DadosResultado dados = conversor.converterDados(jsonlivroBuscado, DadosResultado.class);
            
            if (dados.resultadosBusca().isEmpty()){
                throw new Exception("Busca não retornou resultados.");
            } else {
                DadosLivro livroEncontrado = dados.resultadosBusca().get(0);
                System.out.println(livroEncontrado);
            }        
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao buscar o livro: " + e.getMessage());
        }
    }

    private void listarTodosLivros() {

    }

    private void listarTodosAutores() {
    }

    private void listarAutoresNoAno(int ano) {
       
    }

    private void buscarLivrosIdioma(String idioma) {
        
    }

}
