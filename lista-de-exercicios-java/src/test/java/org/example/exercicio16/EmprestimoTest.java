package org.example.exercicio16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    Pessoa rafflesia = new Pessoa("Rafflesia", 18);
    Emprestimo emprestimo = new Emprestimo(rafflesia);

    @DisplayName("Deve retornar erro ao tentar pegar emprestado um livro indisponível")
    @Test
    void deveRetornarErroEmprestarLivroIndisponivel() {
        LivroDigital bookOfMoon = new LivroDigital("Book of Moon", "Sera", "WWW");
        emprestimo.emprestarLivro(bookOfMoon);

        assertThrows(IllegalArgumentException.class, () -> emprestimo.emprestarLivro(bookOfMoon));
    }

    @DisplayName("Deve adicionar livro a lista de livros emprestados")
    @Test
    void adicionaLivroEmprestado() {
        LivroDigital bookOfMoon = new LivroDigital("Book of Moon", "Sera", "WWW");
        LocalDate data = LocalDate.now().plusWeeks(1);
        List<LivroCadastrado> livros = emprestimo.getLivrosEmprestados();

        assertEquals("Livro \"Book of Moon\" emprestado com sucesso para Rafflesia" +
                        "\nData de devolução: " + data,emprestimo.emprestarLivro(bookOfMoon));
        assertTrue(livros.contains(bookOfMoon));
    }

    @DisplayName("Deve retornar erro ao tentar ter mais de 2 livros emprestados")
    @Test
    void deveRetornarErroAoEmprestarTerceiroLivro() {
        LivroDigital bookOfMoon = new LivroDigital("Book of Moon", "Sera", "WWW");
        LivroFisico bookOfEclipse = new LivroFisico("Book of Eclipse", "Sera", "A14");
        LivroDigital bookOfLife = new LivroDigital("Book of Life", "Sera", "WWW");
        emprestimo.emprestarLivro(bookOfMoon);
        emprestimo.emprestarLivro(bookOfEclipse);

        assertThrows(IllegalArgumentException.class, () -> emprestimo.emprestarLivro(bookOfLife));
    }

    @DisplayName("Deve remover livro da lista de livros emprestados")
    @Test
    void removeLivroEmprestado() {
        LivroFisico bookOfEclipse = new LivroFisico("Book of Eclipse", "Sera", "A14");
        emprestimo.emprestarLivro(bookOfEclipse);
        List<LivroCadastrado> livros = emprestimo.getLivrosEmprestados();

        assertEquals("Livro \"Book of Eclipse\" devolvido com sucesso por Rafflesia",
                emprestimo.devolverLivro(bookOfEclipse));
        assertFalse(livros.contains(bookOfEclipse));
    }

    @DisplayName("Deve retornar erro ao tentar devolver um livro que nã oestá com a pessoa")
    @Test
    void deveRetornarErroAoDevolverLivroNaoEmprestado() {
        LivroDigital bookOfLife = new LivroDigital("Book of Life", "Sera", "WWW");

        assertThrows(IllegalArgumentException.class, () -> emprestimo.devolverLivro(bookOfLife));
    }
}