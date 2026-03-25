package org.parte3.Tests;

import org.junit.jupiter.api.Test;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;
import org.parte3.Model.Domain.Lampada.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LampadaContextTest {

    @Test
    void naoDeveDesligarQuandoJaDesligada() {
        LampadaCasa fake = new LampadaCasa() {
            public void ligar() {}
            public void desligar() {}
        };

        var context = new LampadaContext(List.of(fake));

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                context::desligar
        );

        assertEquals("A lâmpada já está desligada!", ex.getMessage());
    }

    @Test
    void deveLigarEDesligar() {
        LampadaCasa fake = new LampadaCasa() {
            public void ligar() {}
            public void desligar() {}
        };

        var context = new LampadaContext(List.of(fake));

        assertDoesNotThrow(context::ligar);
        assertDoesNotThrow(context::desligar);
    }
}