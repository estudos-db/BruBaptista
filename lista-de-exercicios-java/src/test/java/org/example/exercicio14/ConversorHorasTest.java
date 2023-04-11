package org.example.exercicio14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConversorHorasTest {
    ConversorHoras conversorHoras = new ConversorHoras(7023);

    @DisplayName("Deve receber os segundos que sobraram")
    @Test
    void deveReceberSegundosSobra() {
        assertEquals(3, conversorHoras.receberSegundos());
    }
    @DisplayName("Deve receber os minutos totais")
    @Test
    void deveReceberMinutosTotais() {
        assertEquals(117, conversorHoras.converterMinutos());
    }

    @DisplayName("Deve receber os minutos que sobraram")
    @Test
    void deveReceberMinutosSobra() {
        assertEquals(57, conversorHoras.receberMinutos());
    }

    @DisplayName("Deve receber as horas")
    @Test
    void deveReceberHorasTotais() {
        assertEquals(1, conversorHoras.converterHoras());
    }

    @DisplayName("Deve receber o tempo em horas, minutos e segundos")
    @Test
    void DeveRetornarTempoEmHorasMinutosSegundos() {
        assertEquals("1h57min3seg", conversorHoras.getHoras());
    }
}