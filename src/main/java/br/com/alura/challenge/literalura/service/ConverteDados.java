package br.com.alura.challenge.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T converterDados(String json, Class<T> classe){
       try {
        return mapper.readValue(json, classe);

       } catch (JsonProcessingException e) {
            System.out.println("ERRO DETALHADO DO JACKSON: " + e.getMessage());
            throw new RuntimeException("Falha na conversão do JSON.");
       }
    }
    
}
