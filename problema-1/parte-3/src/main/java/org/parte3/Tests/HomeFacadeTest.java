package org.parte3.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;
import org.parte3.Model.Services.HomeFacade;

import static org.junit.jupiter.api.Assertions.*;

class HomeFacadeTest {

    private HomeFacade home;

    @BeforeEach
    void setup() {
        home = new HomeFacade();
    }

    @Test
    void deveExecutarModoTrabalhoSemErro() {
        assertDoesNotThrow(() -> home.modoTrabalho());
    }

    @Test
    void deveExecutarModoSonoSemErro() {
        assertDoesNotThrow(() -> {
            home.ligarArCondicionados();
            home.ligarLampadas();
            home.abrirPersianas();

            home.modoSono();
        });
    }

    @Test
    void fluxoCompletoNaoDeveQuebrar() {
        assertDoesNotThrow(() -> {
            home.modoTrabalho();
            home.modoSono();
        });
    }


    @Test
    void naoDeveAbrirPersianaJaAberta() throws Exception {
        home.abrirPersianas();

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.abrirPersianas()
        );

        assertEquals("A persiana já está aberta", ex.getMessage());
    }

    @Test
    void naoDeveFecharPersianaJaFechada() {
        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.fecharPersianas()
        );

        assertEquals("A persiana já está fechada!", ex.getMessage());
    }

    @Test
    void deveAbrirEFecharPersianas() {
        assertDoesNotThrow(() -> {
            home.abrirPersianas();
            home.fecharPersianas();
        });
    }


    @Test
    void naoDeveLigarLampadaJaLigada() {
        home.ligarLampadas();

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.ligarLampadas()
        );

        assertEquals("A lâmpada já está ligada!", ex.getMessage());
    }

    @Test
    void naoDeveDesligarLampadaJaDesligada() {
        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.desligarLampadas()
        );

        assertEquals("A lâmpada já está desligada!", ex.getMessage());
    }

    @Test
    void deveLigarEDesligarLampadas() {
        assertDoesNotThrow(() -> {
            home.ligarLampadas();
            home.desligarLampadas();
        });
    }

    @Test
    void naoDeveAumentarTemperaturaComArDesligado() {
        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.aumentarTemperaturaArCondicionados()
        );

        assertEquals("O ar condicionado está desligado!", ex.getMessage());
    }

    @Test
    void naoDeveLigarArJaLigado() {
        home.ligarArCondicionados();

        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.ligarArCondicionados()
        );

        assertEquals("O ar condicionado já está ligado", ex.getMessage());
    }

    @Test
    void deveControlarArCondicionado() {
        assertDoesNotThrow(() -> {
            home.ligarArCondicionados();
            home.aumentarTemperaturaArCondicionados();
            home.diminuirTemperaturaArCondiconados();
            home.definirTemperaturaArCondicionado(25);
            home.desligarArCondicionados();
        });
    }

    @Test
    void naoDeveDesligarArJaDesligado() {
        EstadoInvalidoException ex = assertThrows(
                EstadoInvalidoException.class,
                () -> home.desligarArCondicionados()
        );

        assertEquals("O ar condicionado já está desligado!", ex.getMessage());
    }
}
