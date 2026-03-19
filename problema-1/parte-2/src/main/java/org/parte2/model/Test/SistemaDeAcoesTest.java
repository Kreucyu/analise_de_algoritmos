package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;
import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaDeAcoesTest {

    @Test
    void transacaoOk() {
        Acao acao = new Acao("VALE3", BigDecimal.valueOf(60));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(70)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(70)));

        assertEquals(BigDecimal.valueOf(70), acao.getValorAcao());
    }

    @Test
    void semTransacao() {
        Acao acao = new Acao("VALE3", BigDecimal.valueOf(60));
        SistemaDeAcoes sistema = new SistemaDeAcoes();

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(70)));

        sistema.adicionarOrdemEProcessar(acao,
                new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(80)));

        assertEquals(BigDecimal.valueOf(60), acao.getValorAcao());
    }
}