package org.example.exercicio05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TabuadaTest {

    Tabuada tabuada = new Tabuada();
    @DisplayName("Deve retornar a tabuada do número")
    @Test
    void tabuada() {
        assertEquals("[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]", tabuada.calcular(2));

        assertEquals("2x1=2\n2x2=4\n2x3=6\n2x4=8\n2x5=10" +
                "\n2x6=12\n2x7=14\n2x8=16\n2x9=18\n2x10=20\n", tabuada.calcularSt(2));
    }
}