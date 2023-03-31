package org.example.exercicio03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaquinaTest {
    @DisplayName("A escolha da máquina deve variar entre pedra, papel ou tesoura")
    @Test
    void escolhaMaquina() {
        Maquina maquina = new Maquina();
        Escolhas escolha = maquina.getEscolha();

        assertTrue(escolha == Escolhas.PEDRA || escolha == Escolhas.PAPEL ||
                escolha == Escolhas.TESOURA);
    }
}