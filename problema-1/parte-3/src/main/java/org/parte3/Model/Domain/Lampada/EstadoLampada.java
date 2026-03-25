package org.parte3.Model.Domain.Lampada;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;

public interface EstadoLampada {
    void ligar(LampadaContext lampadaContext);
    void desligar(LampadaContext lampadaContext);
}
