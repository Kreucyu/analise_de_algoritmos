package org.parte3.Tests;

import org.junit.jupiter.api.Test;
import org.parte3.Model.Domain.ArCondicionado.*;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArCondicionadoContextTest {

    @Test
    void naoDeveAlterarTemperaturaDesligado() {
        ArCondicionadoCasa fake = new ArCondicionadoCasa() {
            public void ligar() {}
            public void desligar() {}
            public void aumentarTemperatura() {}
            public void diminuirTemperatura() {}
            public void definirTemperatura(int t) {}
        };

        var context = new ArCondicionadoContext(List.of(fake));

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                context::aumentarTemperatura
        );

        assertEquals("O ar condicionado está desligado!", ex.getMessage());
    }

    @Test
    void deveMudarEstadoAoLigar() {
        var context = new ArCondicionadoContext(List.of(
                new ArCondicionadoCasa() {
                    public void ligar() {}
                    public void desligar() {}
                    public void aumentarTemperatura() {}
                    public void diminuirTemperatura() {}
                    public void definirTemperatura(int t) {}
                }
        ));

        assertDoesNotThrow(context::ligar);
        assertDoesNotThrow(context::aumentarTemperatura);
    }
}
