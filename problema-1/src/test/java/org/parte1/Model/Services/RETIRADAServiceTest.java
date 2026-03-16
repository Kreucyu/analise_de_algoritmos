package org.parte1.Model.Services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RETIRADAServiceTest {

    @Test
    void calcularValorEnvio() {
        RETIRADAService retirada = new RETIRADAService();
        double valorEnvio = retirada.calcularValorDoEnvio(1.0);

        assertEquals(0.0, valorEnvio, "O valor da retirada deve ser R$ 0,00");
    }
}