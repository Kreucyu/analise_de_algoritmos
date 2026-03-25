package org.parte3.Model.Domain.Lampada;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyuMiAdapter implements LampadaCasa {
    private final LampadaShoyuMi lampadaShoyuMi;

    public LampadaShoyuMiAdapter(LampadaShoyuMi lampadaShoyuMi) {
        this.lampadaShoyuMi = lampadaShoyuMi;
    }
    @Override
    public void ligar() {
        lampadaShoyuMi.ligar();
    }

    @Override
    public void desligar() {
        lampadaShoyuMi.desligar();
    }
}
