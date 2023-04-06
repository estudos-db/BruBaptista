package org.example.exercicio03;

import static org.example.exercicio03.Escolha.PEDRA;
import static org.example.exercicio03.Escolha.PAPEL;
import static org.example.exercicio03.Escolha.TESOURA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaquinaTest {
    @DisplayName("A escolha da máquina deve variar entre pedra, papel ou tesoura")
    @Test
    void escolhaMaquina() {
        Maquina maquina = new Maquina();
        Escolha escolha = maquina.getEscolha();

        assertTrue(escolha == PEDRA || escolha == PAPEL ||
                escolha == TESOURA);
    }
}