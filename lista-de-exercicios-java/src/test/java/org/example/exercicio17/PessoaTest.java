package org.example.exercicio17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @DisplayName("Deve retornar erro para idade negativa")
    @Test
    void DeveRetornarErroParaIdadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            Pessoa rafflesia = new Pessoa("Rafflesia", -7);
        });
    }

    @DisplayName("Deve retornar erro para idade maior que 150")
    @Test
    void DeveRetornarErroParaIdadeMaior150() {
        assertThrows(IllegalArgumentException.class, () -> {
            Pessoa rafflesia = new Pessoa("Rafflesia", 151);
        });
    }

    @DisplayName("Deve retornar erro para pai ou mãe com idade menor que o filho")
    @Test
    void deveRetornarErroParaPaiOuMaeComIdadeMenor() {
        Pessoa pudica = new Pessoa("Pudica", 5);

        assertThrows(IllegalArgumentException.class, () -> {
            Pessoa rafflesia = new Pessoa("Rafflesia", 10, null, pudica);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Pessoa rafflesia = new Pessoa("Rafflesia", 10, pudica, null);
        });
    }

    @DisplayName("Deve retornar uma string com pessoa, idade, pai e mãe")
    @Test
    void DeveRetornarStringComNomeIdadePaiMaeDaPessoa() {
        Pessoa pudica = new Pessoa("Pudica", 20);
        Pessoa atrax = new Pessoa("Atrax", 20);
        Pessoa mantis = new Pessoa("Mantis", 10, pudica, atrax);

        String esperadaMantis = "Nome: Mantis, idade: 10\n" +
                                "Pai: Pudica, mãe: Atrax";
        assertEquals(esperadaMantis, mantis.imprimePais());

        String esperadaPudica = "Nome: Pudica, idade: 20\n" +
                                "Pai: Desconhecido, mãe: Desconhecida";
        assertEquals(esperadaPudica, pudica.imprimePais());
    }

    @DisplayName("Deve retornar uma string com a árvore genealógica")
    @Test
    void deveRetornarStringComArvoreGenealogica() {
        Pessoa avoMaterno1 = new Pessoa("AvoMaterno1", 50);
        Pessoa avoMaterno2 = new Pessoa("AvoMaterno2", 50);
        Pessoa mae = new Pessoa("Mae", 30, avoMaterno1, avoMaterno2);

        Pessoa avoPaterno1 = new Pessoa("AvoPaterno1", 50);
        Pessoa avoPaterno2 = new Pessoa("AvoPaterno2", 50);
        Pessoa pai = new Pessoa("Pai", 30, avoPaterno1, avoPaterno2);

        Pessoa pessoa = new Pessoa("Filho", 10, pai, mae);

        String esperada = "\nAncestralidade: 0\n" +
                        "Nome: Filho, idade: 10\n" +
                        "Pai: Pai, mãe: Mae" +
                        "\nAncestralidade: 1\n" +
                        "Nome: Pai, idade: 30\n" +
                        "Pai: AvoPaterno1, mãe: AvoPaterno2" +
                        "\nAncestralidade: 2\n" +
                        "Nome: AvoPaterno1, idade: 50\n" +
                        "Pai: Desconhecido, mãe: Desconhecida" +
                        "\nAncestralidade: 2\n" +
                        "Nome: AvoPaterno2, idade: 50\n" +
                        "Pai: Desconhecido, mãe: Desconhecida" +
                        "\nAncestralidade: 1\n" +
                        "Nome: Mae, idade: 30\n" +
                        "Pai: AvoMaterno1, mãe: AvoMaterno2" +
                        "\nAncestralidade: 2\n" +
                        "Nome: AvoMaterno1, idade: 50\n" +
                        "Pai: Desconhecido, mãe: Desconhecida" +
                        "\nAncestralidade: 2\n" +
                        "Nome: AvoMaterno2, idade: 50\n" +
                        "Pai: Desconhecido, mãe: Desconhecida";

        assertEquals(esperada, pessoa.imprimeArvore());
    }

}