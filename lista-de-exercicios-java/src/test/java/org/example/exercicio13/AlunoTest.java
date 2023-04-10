package org.example.exercicio13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    Aluno aluno = new Aluno();
    @DisplayName("A nota não pode ser menor que zero")
    @Test
    void notaDeveSerIgualOuMaiorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarNota(-10);
        });
    }

    @DisplayName("A nota não pode ser maior que dez")
    @Test
    void notaDeveSerIgualOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarNota(20);
        });
    }

    @DisplayName("Deve adicionar uma nova nota ao grupo de notas")
    @Test
    void a() {
        aluno.adicionarNota(5);

        assertArrayEquals(new Double[] {5.0}, aluno.getNotas().toArray());
    }

    @DisplayName("Deve retornar a média das notas")
    @Test
    void deveRetornarMediaDeNotas() {
        aluno.adicionarNota(1);
        aluno.adicionarNota(5);

        assertEquals(3.0, aluno.calcularMedia());
    }

    @DisplayName("Deve retornar o status correto do aluno")
    @Test
    void deveRetornarStatusCorreto() {
        Aluno alunoAprovado = new Aluno();
        alunoAprovado.adicionarNota(6.1);
        Aluno alunoSuplementar = new Aluno();
        alunoSuplementar.adicionarNota(6);
        Aluno alunoSuplementar2 = new Aluno();
        alunoSuplementar2.adicionarNota(4);
        Aluno alunoReprovado = new Aluno();
        alunoReprovado.adicionarNota(3.9);

        assertEquals("Aprovado", alunoAprovado.calcularStatus());
        assertEquals("Verificação Suplementar", alunoSuplementar.calcularStatus());
        assertEquals("Verificação Suplementar", alunoSuplementar2.calcularStatus());
        assertEquals("Reprovado", alunoReprovado.calcularStatus());
    }

    @DisplayName("Deve retornar o status correto após adicionar uma nova nota")
    @Test
    void deveRetornarStatusCorretoAposAdicionarNota() {
        aluno.adicionarNota(1);
        aluno.adicionarNota(5);

        assertEquals("Reprovado", aluno.calcularStatus());
    }
}