package org.parte3.Model.Domain.Lampada;

import java.util.List;

public class LampadaContext {
    private List<LampadaCasa> lampadas;
    private EstadoLampada estadoLampada;
    public LampadaContext(List<LampadaCasa> lampadas) {
        this.lampadas = lampadas;
        this.estadoLampada = new LampadaDesligada();
    }

    public void ligar() {
        estadoLampada.ligar(this);
    }

    public void desligar() {
        estadoLampada.desligar(this);
    }

    public List<LampadaCasa> getLampadas() {
        return this.lampadas;
    }

    public void definirNovoEstado (EstadoLampada novoEstado) {
        this.estadoLampada = novoEstado;
    }
}
