package org.parte2.model.entities;

import java.math.BigDecimal;

public class Ordem {
    private String NomeInvestidor;
    private TipoOrdem tipoOrdem;
    private BigDecimal valorOrdem;

    public Ordem(String NomeInvestidor, TipoOrdem tipoOrdem, BigDecimal valorOrdem) {
        this.NomeInvestidor = NomeInvestidor;
        this.tipoOrdem = tipoOrdem;
        this.valorOrdem = valorOrdem;
    }

    public String getNomeInvestidor() {
        return NomeInvestidor;
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
                "NomeInvestidor='" + NomeInvestidor + '\'' +
                ", tipoOrdem=" + tipoOrdem +
                ", valorOrdem=" + valorOrdem +
                '}';
    }
}
