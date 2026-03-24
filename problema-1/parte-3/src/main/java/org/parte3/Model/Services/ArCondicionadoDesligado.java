package org.parte3.Model.Services;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Exceptions.ArCondicionadoDesligadoException;

public class ArCondicionadoDesligado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {

    }

    @Override
    public void desligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new ArCondicionadoDesligadoException("O Ar Condicionado já está desligado!");
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        throw new ArCondicionadoDesligadoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        throw new ArCondicionadoDesligadoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void definirTemperatura(int temperatura,ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new ArCondicionadoDesligadoException("O Ar Condicionado está desligado!");
    }
}
