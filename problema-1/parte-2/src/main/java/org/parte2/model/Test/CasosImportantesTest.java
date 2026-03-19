package org.parte2.model;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;

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

        acao.adicionarOrdem(new Ordem("V1", TipoOrdem.VENDA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("V2", TipoOrdem.VENDA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("C1", TipoOrdem.COMPRA, BigDecimal.valueOf(24)));

        assertEquals(1, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(24), acao.getValorAcao());
    }

    @Test
    void mesmoInvNaoECompativel() {
        Acao acao = new Acao("PETR4", BigDecimal.valueOf(30));

        acao.adicionarOrdem(new Ordem("Felipe", TipoOrdem.COMPRA, BigDecimal.valueOf(50)));
        acao.adicionarOrdem(new Ordem("Felipe", TipoOrdem.VENDA, BigDecimal.valueOf(50)));

        assertEquals(2, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(30), acao.getValorAcao());
    }

    @Test
    void notificaInv() {
        Acao acao = new Acao("VALE3", BigDecimal.valueOf(60));
        ObsFake obs = new ObsFake();

        acao.addObserver(obs);

        acao.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(70)));
        acao.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(70)));

        assertTrue(obs.ok);
        assertEquals(BigDecimal.valueOf(70), obs.valor);
    }

    @Test
    void variasAcoes() {
        Acao a1 = new Acao("PETR4", BigDecimal.valueOf(30));
        Acao a2 = new Acao("VALE3", BigDecimal.valueOf(60));

        ObsFake obs = new ObsFake();

        a1.addObserver(obs);
        a2.addObserver(obs);

        a1.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(40)));
        a1.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(40)));

        assertTrue(obs.ok);

        obs.ok = false;

        a2.adicionarOrdem(new Ordem("C", TipoOrdem.COMPRA, BigDecimal.valueOf(80)));
        a2.adicionarOrdem(new Ordem("D", TipoOrdem.VENDA, BigDecimal.valueOf(80)));

        assertTrue(obs.ok);
    }
}