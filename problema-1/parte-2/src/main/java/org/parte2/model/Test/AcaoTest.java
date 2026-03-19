package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;
import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AcaoTest {

    @Test
    void addOrdem() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        Investidor inv = new Investidor("Professor Gabriel");

        Ordem ordem = new Ordem(inv, TipoOrdem.COMPRA, BigDecimal.valueOf(24));

        acao.adicionarOrdem(ordem);

        assertEquals(1, acao.listarOrdens().size());
    }

    @Test
    void matchSimples() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor i1 = new Investidor("Elcio");
        Investidor i2 = new Investidor("Jonathan");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(24)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(24)));

        assertEquals(0, acao.listarOrdens().size());
        assertEquals(BigDecimal.valueOf(24), acao.getValorAcao());
    }

    @Test
    void semMatch() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor i1 = new Investidor("Felipe");
        Investidor i2 = new Investidor("Joao");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(24)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(25)));

        assertEquals(2, acao.listarOrdens().size());
        assertEquals(BigDecimal.valueOf(20), acao.getValorAcao());
    }

    @Test
    void umaVendaSo() {
        Acao acao = new Acao("BBAS3", BigDecimal.valueOf(20));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor v1 = new Investidor("Zezinho");
        Investidor v2 = new Investidor("Carlos");
        Investidor c1 = new Investidor("Pedro");

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
    void mesmoInvestidor() {
        Acao acao = new Acao("PETR4", BigDecimal.valueOf(30));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor inv = new Investidor("Joao");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(inv, TipoOrdem.COMPRA, BigDecimal.valueOf(50)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(inv, TipoOrdem.VENDA, BigDecimal.valueOf(50)));

        assertEquals(2, acao.listarOrdens().size());
        assertEquals(BigDecimal.valueOf(30), acao.getValorAcao());
    }
}