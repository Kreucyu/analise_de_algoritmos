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

        acao.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(70)));
        acao.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(70)));

        assertEquals(BigDecimal.valueOf(70), acao.getValorAcao());
    }

    @Test
    void semTransacao() {
        Acao acao = new Acao("VALE3", BigDecimal.valueOf(60));

        acao.adicionarOrdem(new Ordem("A", TipoOrdem.COMPRA, BigDecimal.valueOf(70)));
        acao.adicionarOrdem(new Ordem("B", TipoOrdem.VENDA, BigDecimal.valueOf(80)));

        assertEquals(BigDecimal.valueOf(60), acao.getValorAcao());
    }
}