package org.parte3.Model.Entities;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.parte3.Model.Exceptions.LampadaApagadaException;

public class LampadaDesligada implements EstadoLampada {
    @Override
    public void ligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi) {
        lampadaPhellipes.setIntensidade(100);
        lampadaShoyuMi.ligar();
    }

    @Override
    public void desligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi) {
        throw new LampadaApagadaException("A lâmpada já está apagada!");
    }
}
