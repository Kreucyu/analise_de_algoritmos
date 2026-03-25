package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public interface EstadoArCondicionado {
    void ligar(ArCondicionadoContext arCondicionadoContext);
    void desligar(ArCondicionadoContext arCondicionadoContext);
    void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext);
    void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext);
    void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext);
}
