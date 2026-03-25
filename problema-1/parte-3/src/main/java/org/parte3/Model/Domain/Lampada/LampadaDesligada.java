package org.parte3.Model.Domain.Lampada;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class LampadaDesligada implements EstadoLampada {
    @Override
    public void ligar(LampadaContext lampadaContext) {
        for(LampadaCasa lampadas : lampadaContext.listarLampadas()) {
            lampadas.ligar();
        }
        lampadaContext.definirNovoEstado(new LampadaLigada());
    }

    @Override
    public void desligar(LampadaContext lampadaContext) {
        throw new EstadoInvalidoException("A lâmpada já está desligada!");
    }
}
