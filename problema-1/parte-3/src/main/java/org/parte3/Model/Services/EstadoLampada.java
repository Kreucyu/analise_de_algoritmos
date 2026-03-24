package org.parte3.Model.Services;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;

public interface EstadoLampada {
    void ligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi);
    void desligar(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi);
}
