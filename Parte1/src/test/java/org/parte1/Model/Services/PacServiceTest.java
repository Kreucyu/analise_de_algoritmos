package org.parte1.Model.Services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PACServiceTest {

    @Test
    void calcularValorEnvioAte1Kg() {
        PACService pac = new PACService();
        double valorEnvio = pac.calcularValorDoEnvio(0.5);

        assertEquals(10.0, valorEnvio, "O valor do PAC para até 1kg deve ser R$ 10,00");
    }

    @Test
    void calcularValorEnvioAte2Kg() {
        PACService pac = new PACService();
        double valorEnvio = pac.calcularValorDoEnvio(1.5);

        assertEquals(15.0, valorEnvio, "O valor do PAC para até 2kg deve ser R$ 15,00");
    }

    @Test
    void calcularValorEnvioAcimaDe2Kg() {
        PACService pac = new PACService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pac.calcularValorDoEnvio(2.5);
        });

        assertEquals("Não é possível fazer entregas PAC acima de 2Kg!", exception.getMessage());
    }
}