package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoDesligado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {

    }

    @Override
    public void desligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new EstadoInvalidoException("O Ar Condicionado já está desligado!");
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void definirTemperatura(int temperatura,ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }
}
