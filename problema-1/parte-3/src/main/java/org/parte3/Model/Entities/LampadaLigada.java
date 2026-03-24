package org.parte3.Model.Entities;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.parte3.Model.Exceptions.LampadaAcesaException;

public class LampadaLigada implements EstadoLampada {
    @Override
    public void ligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi) {
        throw new LampadaAcesaException("A lâmpada já está acesa!");
    }

    @Override
    public void desligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi) {
        lampadaPhellipes.setIntensidade(0);
        lampadaShoyuMi.desligar();
    }
}
