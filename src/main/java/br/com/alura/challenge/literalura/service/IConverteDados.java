package br.com.alura.challenge.literalura.service;

public interface IConverteDados {

    <T> T converterDados(String json, Class<T> classe);
}
