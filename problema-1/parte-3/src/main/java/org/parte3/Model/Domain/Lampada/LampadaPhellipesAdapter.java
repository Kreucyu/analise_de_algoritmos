package org.parte3.Model.Domain.Lampada;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class LampadaPhellipesAdapter implements LampadaCasa {
    private final LampadaPhellipes lampadaPhellipes;

    public LampadaPhellipesAdapter(LampadaPhellipes lampadaPhellipes) {
        this.lampadaPhellipes = lampadaPhellipes;
    }
    @Override
    public void ligar() {
        lampadaPhellipes.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampadaPhellipes.setIntensidade(0);
    }
}
