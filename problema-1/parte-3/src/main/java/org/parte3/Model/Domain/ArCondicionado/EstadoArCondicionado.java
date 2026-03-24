package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public interface EstadoArCondicionado {
    void ligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn);
    void desligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn);
    void aumentarTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza);
    void diminuirTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza);
    void definirTemperatura(int temperatura,ArCondicionadoVentoBaumn arCondicionadoVentoBaumn);
}
