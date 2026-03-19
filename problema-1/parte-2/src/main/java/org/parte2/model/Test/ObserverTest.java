package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;

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
        InvestidorFake inv = new InvestidorFake();

        acao.addObserver(inv);

        acao.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(30)));
        acao.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(30)));

        assertTrue(inv.notificado);
        assertEquals(BigDecimal.valueOf(30), inv.valor);
    }

    @Test
    void variasAcoes() {
        Acao a1 = new Acao("PETR4", BigDecimal.valueOf(30));
        Acao a2 = new Acao("VALE3", BigDecimal.valueOf(60));

        InvestidorFake inv = new InvestidorFake();

        a1.addObserver(inv);
        a2.addObserver(inv);

        a1.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(40)));
        a1.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(40)));

        assertTrue(inv.notificado);

        inv.notificado = false;

        a2.adicionarOrdem(new Ordem("C", TipoOrdem.COMPRA, BigDecimal.valueOf(80)));
        a2.adicionarOrdem(new Ordem("D", TipoOrdem.VENDA, BigDecimal.valueOf(80)));

        assertTrue(inv.notificado);
    }
}