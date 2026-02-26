<div align="center">
  
  # 📚 Literalura - Catálogo de Livros

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-warning?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
</div>

## 📌 Sobre o Projeto
O Literalura é uma aplicação em linha de comando (CLI) desenvolvida como parte do challenge da Alura. O objetivo do projeto é construir um catálogo de livros que consome a API pública do **Gutendex**, manipula dados em formato JSON e os persiste de forma estruturada em um banco de dados relacional.

A aplicação garante a integridade dos dados, evitando a duplicação de autores e livros, e permite a interação do usuário através de um menu dinâmico no console.

## 🚀 Funcionalidades
- **Opção 1 - Buscar livro pelo título**: Consome a API Gutendex, valida a existência prévia no banco de dados e salva o novo livro e autor.
- **Opção 2 - Listar livros registrados**: Retorna todos os livros salvos no banco, ordenados alfabeticamente.
- **Opção 3 - Listar autores registrados**: Retorna todos os autores salvos na base de dados com seus anos de nascimento e falecimento.
- **Opção 4 - Listar autores vivos em um determinado ano**: Realiza uma busca temporal no banco de dados cruzando anos de nascimento e falecimento.
- **Opção 5 - Buscar livros por idioma**: Filtra e lista os livros armazenados de acordo com idiomas específicos (PT, EN, ES, FR).

## 🛠️ Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate** (Mapeamento Objeto-Relacional)
* **PostgreSQL** (Banco de Dados)
* **Flyway** (Migrations do Banco de Dados)
* **Jackson** (Desserialização de JSON para DTOs)
* **API Gutendex** (Fonte externa de dados)

## 🚧 Próximos Passos
- [ ] Tratar exceções de input do usuário no menu principal (ex: digitar letras ao invés de números).
- [ ] Adicionar funcionalidades: 1. top 10 livros mais baixados; 2. buscar autor por nome; 3. buscar livro por título cadastrado no banco.
