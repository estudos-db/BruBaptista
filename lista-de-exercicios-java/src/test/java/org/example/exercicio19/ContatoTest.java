package org.example.exercicio19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContatoTest {

    Endereco endereco = new Endereco
            (02012021,
                    "Av. Olavo Fontoura",
                    1209,
                    "Santana",
                    "São Paulo",
                    "SP");
    Contato rafflesia = new Contato("Rafflesia",
            25,
            999991111,
            "rafflesia@trap.com",
            endereco);

    @DisplayName("Deve retornar as informações do contato")
    @Test
    void retornaContato() {
        assertEquals("Nome: Rafflesia\n" +
                "Telefone: (25)999991111\n" +
                "E-mail: rafflesia@trap.com\n" +
                "CEP: 529425\n" +
                "Av. Olavo Fontoura, 1209, \n" +
                "Santana\n" +
                "São Paulo, SP", rafflesia.info());
    }

    @DisplayName("Deve alterar o nome do contato")
    @Test
    void alteraNome() {
        rafflesia.setNome("pudica");

        assertEquals("pudica", rafflesia.getNome());
    }

    @DisplayName("Deve retornar erro se o nome for vazio")
    @Test
    void deveRetornarErroNomeVazio() {

        assertThrows(IllegalArgumentException.class, () -> rafflesia.setNome(""));
    }

    @DisplayName("Deve alterar o ddd do contato")
    @Test
    void alteraDdd() {
        rafflesia.setDdd(11);

        assertEquals(11, rafflesia.getDdd());
    }

    @DisplayName("Deve retornar erro se o ddd possuir menos ou mais de 2 dígitos")
    @Test
    void deveRetornarErroDddComMaisOuMenosDe2Digitos() {

        assertThrows(IllegalArgumentException.class, () -> rafflesia.setDdd(1));
        assertThrows(IllegalArgumentException.class, () -> rafflesia.setDdd(111));
    }

    @DisplayName("Deve alterar o telefone do contato")
    @Test
    void alteraTelefone() {
        rafflesia.setTelefone(989879898);

        assertEquals(989879898, rafflesia.getTelefone());
    }

    @DisplayName("Deve retornar erro se o telefone tiver menos de 8, ou mais de 9 dígitos")
    @Test
    void deveRetornarErroTelefoneComMenosDe8OuMaisDe9Digitos() {

        assertThrows(IllegalArgumentException.class, () -> rafflesia.setTelefone(1234567));
        assertThrows(IllegalArgumentException.class, () -> rafflesia.setTelefone(1234567890));
    }

    @DisplayName("Deve alterar o e-mail do contato")
    @Test
    void alteraEmail() {
        rafflesia.setEmail("pudica@trap.com");

        assertEquals("pudica@trap.com", rafflesia.getEmail());
    }

    @DisplayName("Deve retornar erro se o e-mail não tiver @")
    @Test
    void deveRetornarErroEmailSemArroba() {

        assertThrows(IllegalArgumentException.class, () -> rafflesia.setEmail("pudica.trap.com"));
    }

    @DisplayName("Deve retornar erro se o e-mail com espaço")
    @Test
    void deveRetornarErroEmailComEspaco() {

        assertThrows(IllegalArgumentException.class, () -> rafflesia.setEmail("pudica@trap com"));
    }
}
