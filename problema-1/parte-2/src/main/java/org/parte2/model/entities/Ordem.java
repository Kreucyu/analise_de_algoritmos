package org.parte2.model.entities;

import java.math.BigDecimal;

public class Ordem {
    private Investidor investidor;
    private TipoOrdem tipoOrdem;
    private BigDecimal valorOrdem;

    public Ordem(Investidor investidor, TipoOrdem tipoOrdem, BigDecimal valorOrdem) {
        this.investidor = investidor;
        this.tipoOrdem = tipoOrdem;
        this.valorOrdem = valorOrdem;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public TipoOrdem getTipoOrdem() {
        return tipoOrdem;
    }

    public BigDecimal getValorOrdem() {
        return valorOrdem;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "investidor=" + investidor +
                ", tipoOrdem=" + tipoOrdem +
                '}';
    }
}
