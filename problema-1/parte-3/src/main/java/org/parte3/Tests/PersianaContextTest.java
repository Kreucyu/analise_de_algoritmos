package org.parte3.Tests;

import org.junit.jupiter.api.Test;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;
import org.parte3.Model.Domain.Persiana.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersianaContextTest {

    @Test
    void naoDeveFecharQuandoJaFechada() {
        PersianaCasa fake = new PersianaCasa() {
            public void abrir() {}
            public void fechar() {}
        };

        var context = new PersianaContext(List.of(fake));

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                context::fechar
        );

        assertEquals("A persiana já está fechada!", ex.getMessage());
    }

    @Test
    void deveAbrirEFechar() {
        PersianaCasa fake = new PersianaCasa() {
            public void abrir() {}
            public void fechar() {}
        };

        var context = new PersianaContext(List.of(fake));

        assertDoesNotThrow(context::abrir);
        assertDoesNotThrow(context::fechar);
    }
}