package org.parte3.Model.Domain.Lampada;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class LampadaLigada implements EstadoLampada {
    @Override
    public void ligar(LampadaContext lampadaContext) {
        throw new EstadoInvalidoException("A lâmpada já está ligada!");
    }

    @Override
    public void desligar(LampadaContext lampadaContext) {
        for(LampadaCasa lampada : lampadaContext.getLampadas()) {
            lampada.desligar();
        }
        lampadaContext.setNovoEstado(new LampadaDesligada());
    }
}
