package org.parte1.Model.Services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SEDEXServiceTest {

    @Test
    void calcularValorEnvioAte500g() {
        SEDEXService sedex = new SEDEXService();
        double valorEnvio = sedex.calcularValorDoEnvio(0.4);

        assertEquals(12.50, valorEnvio, "O valor do SEDEX para até 500g deve ser R$ 12,50");
    }

    @Test
    void calcularValorEnvioAte1Kg() {
        SEDEXService sedex = new SEDEXService();
        double valorEnvio = sedex.calcularValorDoEnvio(0.8);

        assertEquals(20.0, valorEnvio, "O valor do SEDEX para até 1kg deve ser R$ 20,00");
    }

    @Test
    void calcularValorEnvioAcimaDe1Kg() {
        SEDEXService sedex = new SEDEXService();
        double valorEnvio = sedex.calcularValorDoEnvio(1.5);

        assertTrue(valorEnvio > 0, "O valor do SEDEX para mais de 1kg deve ser maior que 20,00");
    }
}