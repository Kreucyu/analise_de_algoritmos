package org.parte3.Tests;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.junit.jupiter.api.Test;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;
import org.parte3.Model.Domain.Lampada.LampadaDesligada;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    void naoDeveDesligarLampadaJaDesligada() {
        var estado = new LampadaDesligada();

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> estado.desligar(
                        new LampadaPhellipes(),
                        new LampadaShoyuMi()
                )
        );

        assertEquals("A lâmpada já está apagada!", ex.getMessage());
    }
}