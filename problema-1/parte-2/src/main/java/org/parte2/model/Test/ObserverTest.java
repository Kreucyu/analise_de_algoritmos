package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;
import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

class InvestidorFake implements Observer {
    boolean notificado = false;
    BigDecimal valor;

    @Override
    public void update(Observable o, Object arg) {
        notificado = true;
        valor = (BigDecimal) arg;
    }
}

public class ObserverTest {

    @Test
    void notifica() {
        Acao acao = new Acao("ITUB4", BigDecimal.valueOf(25));
        SistemaDeAcoes sistema = new SistemaDeAcoes();
        InvestidorFake inv = new InvestidorFake();

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        acao.addObserver(inv);

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(30)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(30)));

        assertTrue(inv.notificado);
        assertEquals(BigDecimal.valueOf(30), inv.valor);
    }
}