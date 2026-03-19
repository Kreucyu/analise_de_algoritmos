package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AcaoTest {

    @Test
    void addOrdem() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        Ordem ordem = new Ordem("Professor Gabriel", TipoOrdem.COMPRA, BigDecimal.valueOf(24));

        acao.adicionarOrdem(ordem);

        assertEquals(1, acao.getListaDeOrdens().size());
    }

    @Test
    void matchSimples() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));

        acao.adicionarOrdem(new Ordem("Elcio", TipoOrdem.COMPRA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("Jonathan", TipoOrdem.VENDA, BigDecimal.valueOf(24)));

        assertEquals(0, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(24), acao.getValorAcao());
    }

    @Test
    void semMatch() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));

        acao.adicionarOrdem(new Ordem("Felipe", TipoOrdem.COMPRA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("Joao", TipoOrdem.VENDA, BigDecimal.valueOf(25)));

        assertEquals(2, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(20), acao.getValorAcao());
    }

    @Test
    void umaVendaSo() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));

        acao.adicionarOrdem(new Ordem("Zezinho", TipoOrdem.VENDA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("Carlos", TipoOrdem.VENDA, BigDecimal.valueOf(24)));
        acao.adicionarOrdem(new Ordem("Pedro", TipoOrdem.COMPRA, BigDecimal.valueOf(24)));

        assertEquals(1, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(24), acao.getValorAcao());
    }

    @Test
    void mesmoInvestidor() {
        Acao acao = new Acao("PETR4", BigDecimal.valueOf(30));

        acao.adicionarOrdem(new Ordem("Joao", TipoOrdem.COMPRA, BigDecimal.valueOf(50)));
        acao.adicionarOrdem(new Ordem("Joao", TipoOrdem.VENDA, BigDecimal.valueOf(50)));

        assertEquals(2, acao.getListaDeOrdens().size());
        assertEquals(BigDecimal.valueOf(30), acao.getValorAcao());
    }
}