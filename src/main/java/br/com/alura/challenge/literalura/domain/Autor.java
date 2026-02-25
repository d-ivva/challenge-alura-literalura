package br.com.alura.challenge.literalura.domain;

public class Autor {
    private String nome;
    private String anoNascimento;
    private String anoFalecimento;
    
    public Autor(String nome, String anoNascimento, String anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

}