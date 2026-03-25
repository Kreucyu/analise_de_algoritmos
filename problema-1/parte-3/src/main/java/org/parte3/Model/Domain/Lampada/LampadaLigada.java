package org.parte3.Model.Domain.Lampada;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class LampadaLigada implements EstadoLampada {
    @Override
    public void ligar(LampadaContext lampadaContext) {
        throw new EstadoInvalidoException("A lâmpada já está ligada!");
    }

    @Override
    public void desligar(LampadaContext lampadaContext) {
        for(LampadaCasa lampadas : lampadaContext.listarLampadas()) {
            lampadas.desligar();
        }
        lampadaContext.definirNovoEstado(new LampadaDesligada());
    }
}
