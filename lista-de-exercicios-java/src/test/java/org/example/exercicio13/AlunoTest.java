package org.example.exercicio13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    @DisplayName("A nota não pode ser menor que zero")
    @Test
    void notaDeveSerIgualOuMaiorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Aluno aluno = new Aluno(-10);
        });
    }

    @DisplayName("A nota não pode ser maior que dez")
    @Test
    void notaDeveSerIgualOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            Aluno aluno = new Aluno(20);
        });
    }

    @DisplayName("Deve adicionar uma nova nota ao grupo de notas")
    @Test
    void a() {
        Aluno aluno = new Aluno(1);
        aluno.adicionarNota(5);

        assertArrayEquals(new Double[] {1.0, 5.0}, aluno.getNotas().toArray());
    }

    @DisplayName("Deve retornar a média das notas")
    @Test
    void deveRetornarMediaDeNotas() {
        Aluno aluno = new Aluno(1);
        aluno.adicionarNota(5);

        assertEquals(3.0, aluno.getMedia());
    }

    @DisplayName("Deve retornar o status correto do aluno")
    @Test
    void deveRetornarStatusCorreto() {
        Aluno alunoAprovado = new Aluno(6.1);
        Aluno alunoSuplementar = new Aluno(6);
        Aluno alunoSuplementar2 = new Aluno(4);
        Aluno alunoReprovado = new Aluno(3.9);

        assertEquals("Aprovado", alunoAprovado.getStatus());
        assertEquals("Verificacao Suplementar", alunoSuplementar.getStatus());
        assertEquals("Verificacao Suplementar", alunoSuplementar2.getStatus());
        assertEquals("Reprovado", alunoReprovado.getStatus());
    }

    @DisplayName("Deve retornar o status correto após adicionar uma nova nota")
    @Test
    void deveRetornarStatusCorretoAposAdicionarNota() {
        Aluno aluno = new Aluno(1);
        aluno.adicionarNota(5);

        assertEquals("Reprovado", aluno.getStatus());
    }
}