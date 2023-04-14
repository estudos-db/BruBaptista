package org.example.exercicio19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    Endereco endereco = new Endereco
            (02012021,
                    "Av. Olavo Fontoura",
                    1209,
                    "Santana",
                    "São Paulo",
                    "SP");
    @DisplayName("Deve retornar as informações do endereço")
    @Test
    void retornaInfoEndereco() {
        assertEquals("529425\n" +
                "Av. Olavo Fontoura, 1209, \n" +
                "Santana\n" +
                "São Paulo, SP", endereco.info());
    }

    @DisplayName("Deve alterar o estado do endereço")
    @Test
    void alteraEstado() {
        endereco.setEstado("rj");

        assertEquals("RJ", endereco.getEstado());
    }

    @DisplayName("Deve retornar erro se o estado tiver mais de 2 letras")
    @Test
    void deveRetornarErroEstadoComMaisDe2Letras() {

        assertThrows(IllegalArgumentException.class, () -> endereco.setEstado("rjo"));
    }
}