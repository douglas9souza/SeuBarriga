package br.com.projetoSeuBarriga.data;

import com.github.javafaker.Faker;

import java.util.Random;

public class GeradorDeValoresRandomicos {
    Faker faker = new Faker();

    public String getValoresNome() {
        String nome = faker.name().firstName();
        return nome;
    }


}
