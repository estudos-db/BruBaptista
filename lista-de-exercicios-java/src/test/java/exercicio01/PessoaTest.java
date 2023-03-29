package exercicio01;

import org.example.exercicio01.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @DisplayName("Deve conter uma idade maior ou igual a zero")
    @Test
    void idadeMaiorZero() {
        Pessoa pessoaNegativa = new Pessoa("pessoaNegativa", -18);
        Pessoa pessoaZero = new Pessoa("pessoaZero", 0);
        Pessoa pessoaDez = new Pessoa("pessoaDez", 10);

        assertEquals(0, pessoaNegativa.getIdade());
        assertEquals(0, pessoaZero.getIdade());
        assertEquals(10, pessoaDez.getIdade());
    }

    @DisplayName("Deve retornar true se a idade for maior ou igual a 18")
    @Test
    void idadeMaiorIgual18() {
        Pessoa pessoaDez = new Pessoa("pessoaDez", 10);
        Pessoa pessoaDezoito = new Pessoa("pessoaDezoito", 18);
        Pessoa pessoaVinte = new Pessoa("pessoaVinte", 20);

        assertEquals(false, pessoaDez.verificarIdade());
        assertEquals(true, pessoaDezoito.verificarIdade());
        assertEquals(true, pessoaVinte.verificarIdade());
    }
}
