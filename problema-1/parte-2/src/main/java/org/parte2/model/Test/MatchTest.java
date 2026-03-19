package org.parte2.model.Test;

import org.junit.jupiter.api.Test;
import org.parte2.model.entities.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    void criaMatchCorretamente() {
        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        Ordem compra = new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(50));
        Ordem venda = new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(50));

        Match match = new Match(compra, venda);

        assertEquals(compra, match.getCompra());
        assertEquals(venda, match.getVenda());
    }

    @Test
    void investidoresDiferentes() {
        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        Ordem compra = new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(50));
        Ordem venda = new Ordem(i2, TipoOrdem.VENDA, BigDecimal.valueOf(50));

        Match match = new Match(compra, venda);

        assertFalse(match.envolveMesmoInvestidor());
    }

    @Test
    void mesmoInvestidor() {
        Investidor i1 = new Investidor("A");

        Ordem compra = new Ordem(i1, TipoOrdem.COMPRA, BigDecimal.valueOf(50));
        Ordem venda = new Ordem(i1, TipoOrdem.VENDA, BigDecimal.valueOf(50));

        Match match = new Match(compra, venda);

        assertTrue(match.envolveMesmoInvestidor());
    }
}