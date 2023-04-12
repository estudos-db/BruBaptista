package org.example.exercicio16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PessoaTest {

    Pessoa rafflesia = new Pessoa("Rafflesia", 18);

    @DisplayName("Deve adicionar um livro a lista de livros lidos")
    @Test
    void adicionaLivroLido() {
        LivroDigital bookOfMoon = new LivroDigital("Book of Moon", "Sera", "WWW");
        rafflesia.adicionarLivroLido(bookOfMoon);
        List<LivroCadastrado> livros = rafflesia.getLivrosLidos();

        assertTrue(livros.contains(bookOfMoon));
    }

    @DisplayName("Deve retornar erro ao tentar adicionar livro repetido a lista")
    @Test
    void deveRetornarErroAoAdicionarLivroRepetido() {
        LivroDigital bookOfMoon = new LivroDigital("Book of Moon", "Sera", "WWW");
        rafflesia.adicionarLivroLido(bookOfMoon);

        assertThrows(IllegalArgumentException.class, () -> rafflesia.adicionarLivroLido(bookOfMoon));
    }

    @DisplayName("Deve remover um livro da lista de livros lidos")
    @Test
    void removeLivroLido() {
        LivroFisico bookOfEclipse = new LivroFisico("Book of Eclipse", "Sera", "A14");
        rafflesia.adicionarLivroLido(bookOfEclipse);
        rafflesia.removerLivroLido(bookOfEclipse);
        List<LivroCadastrado> livros = rafflesia.getLivrosLidos();

        assertFalse(livros.contains(bookOfEclipse));
    }

    @DisplayName("Deve retornar erro ao tentar remover livro não presente na lista")
    @Test
    void deveRetornarErroAoRemoverLivroNaoPresente() {
        LivroFisico bookOfEclipse = new LivroFisico("Book of Eclipse", "Sera", "A14");

        assertThrows(IllegalArgumentException.class, () -> rafflesia.removerLivroLido(bookOfEclipse));
    }
}