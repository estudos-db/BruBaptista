package org.example.exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    Personagem kiriko = new Personagem("Kiriko", 19, "Folha", 10);
    @DisplayName("Deve retornar erro ao tentar criar um personagem com chakra menor que 0 ou maior que 10")
    @Test
    void deveRetornarErroPersonagemComChakraMenorQueZeroOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            Personagem personagemZero = new Personagem("zero", 10, "Folha", -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Personagem personagemDez = new Personagem("dez", 10, "Folha", 11);
        });
    }

    @DisplayName("Deve adicionar um jutsu a lista de jutsus")
    @Test
    void deveAdicionarUmJustsu() {
        assertEquals("O ninja Kiriko aprendeu o jutsu: teleporte", kiriko.aprenderJutsu("teleporte"));
        assertArrayEquals(new String[]{"teleporte"}, kiriko.getJutsus());
    }

    @DisplayName("Deve retornar mensagem de erro ao tentar adicionar um segundo jutsu")
    @Test
    void deveRetornarMensagemDeErroAdicionarSegundoJutsu() {
        kiriko.aprenderJutsu("teleporte");

        assertEquals("Um ninja iniciante não pode aprender mais de um jutsu",
                kiriko.aprenderJutsu("teleporte"));
    }

    @DisplayName("Deve aumentar a quantidade de chakra")
    @Test
    void deveAumentarQuantidadeDeChakra() {
        assertEquals("O total de chakra do ninja Kiriko agora é 15", kiriko.aumentarChakra(5));
    }

    @DisplayName("Deve retornar mensagem de erro ao tentar aumentar a quantidade de chakra em valor zero ou nulo")
    @Test
    void deveRetornarMensagemDeErroAumentarQuantidadeDeChakraEmZeroOuNuloOuValorMuitoMaiorQueInicial() {
        assertEquals("O aumento do chakra não pode ser nulo ou negativo", kiriko.aumentarChakra(0));
        assertEquals("O aumento do chakra não pode ser nulo ou negativo", kiriko.aumentarChakra(-1));

        assertEquals("Um ninja não pode evoluir tanto assim de uma vez", kiriko.aumentarChakra(6));
    }

    @DisplayName("Deve retornar uma string com todas as informações do ninja")
    @Test
    void deveRetornarTodasInformacoesDoNinja() {
        assertEquals("Personagem:\n" +
                                "Nome: Kiriko\n" +
                                "Idade: 19\n" +
                                "Aldeia: Folha\n" +
                                "Chakra total: 10\n" +
                                "Lista de jutsus: [null]", kiriko.getInfo());

        kiriko.aprenderJutsu("Clone das sombras");
        assertEquals("Personagem:\n" +
                                "Nome: Kiriko\n" +
                                "Idade: 19\n" +
                                "Aldeia: Folha\n" +
                                "Chakra total: 10\n" +
                                "Lista de jutsus: [Clone das sombras]", kiriko.getInfo());
    }
}