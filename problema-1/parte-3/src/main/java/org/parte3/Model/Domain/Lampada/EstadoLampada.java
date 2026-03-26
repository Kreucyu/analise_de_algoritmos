package org.parte3.Model.Domain.Lampada;

import org.parte3.Model.Domain.ArCondicionado.ArCondicionadoCasa;

import java.util.function.Consumer;

public interface EstadoLampada {
    void ligar(LampadaContext lampadaContext);
    void desligar(LampadaContext lampadaContext);
}
