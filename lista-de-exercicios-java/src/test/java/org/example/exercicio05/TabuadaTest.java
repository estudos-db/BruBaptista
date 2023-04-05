package org.example.exercicio05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TabuadaTest {

    Tabuada tabuada = new Tabuada(2);
    @DisplayName("Deve retornar a tabuada do número")
    @Test
    void tabuada() {
        assertEquals("[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]", tabuada.calcular());
        assertEquals("[2x0=2\n, 2x1=4\n, 2x2=6\n, 2x3=8\n, 2x4=10\n, 2x5=12\n"
                + ", 2x6=14\n, 2x7=16\n, 2x8=18\n, 2x9=20\n]", tabuada.calcularSt());
    }
}