package org.parte2.model;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;
import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

class ObsFake implements Observer {
    boolean ok = false;
    BigDecimal valor;

    @Override
    public void update(Observable o, Object arg) {
        ok = true;
        valor = (BigDecimal) arg;
    }
}

public class CasosImportantesTest {

    @Test
    void vendeUmaSo() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor v1 = new Investidor("V1");
        Investidor v2 = new Investidor("V2");
        Investidor c1 = new Investidor("C1");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(v1, TipoOrdem.VENDA, BigDecimal.valueOf(24)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(v2, TipoOrdem.VENDA, BigDecimal.valueOf(24)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(c1, TipoOrdem.COMPRA, BigDecimal.valueOf(24)));

        assertEquals(1, acao.listarOrdens().size());
        assertEquals(BigDecimal.valueOf(24), acao.getValorAcao());
    }

    @Test
    void mesmoInvNaoECompativel() {
        Acao acao = new Acao("PETR4", BigDecimal.valueOf(30));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor inv = new Investidor("Felipe");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(inv, TipoOrdem.COMPRA, BigDecimal.valueOf(50)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(inv, TipoOrdem.VENDA, BigDecimal.valueOf(50)));

        assertEquals(2, acao.listarOrdens().size());
        assertEquals(BigDecimal.valueOf(30), acao.getValorAcao());
    }

    @Test
    void notificaInv() {
        Acao acao = new Acao("VALE3", BigDecimal.valueOf(60));
        SistemaDeAcoes sistema = new SistemaDeAcoes();
        ObsFake obs = new ObsFake();

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        acao.addObserver(obs);

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(70)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(70)));

        assertTrue(obs.ok);
        assertEquals(BigDecimal.valueOf(70), obs.valor);
    }
}