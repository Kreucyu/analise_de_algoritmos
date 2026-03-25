package org.parte3.Model.Domain.Lampada;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class LampadaDesligada implements EstadoLampada {
    @Override
    public void ligar(LampadaContext lampadaContext) {
        for(LampadaCasa lampada : lampadaContext.getLampadas()) {
            lampada.ligar();
        }
        lampadaContext.setNovoEstado(new LampadaLigada());
    }

    @Override
    public void desligar(LampadaContext lampadaContext) {
        throw new EstadoInvalidoException("A lâmpada já está desligada!");
    }
}
