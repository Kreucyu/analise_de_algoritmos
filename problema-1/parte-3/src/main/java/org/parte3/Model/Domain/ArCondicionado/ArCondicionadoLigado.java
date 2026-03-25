package org.parte3.Model.Domain.ArCondicionado;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado já está ligado");
    }

    @Override
    public void desligar(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            arCondicionado.desligar();
        }
        arCondicionadoContext.definirNovoEstado(new ArCondicionadoDesligado());
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            arCondicionado.aumentarTemperatura();
        }
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            arCondicionado.diminuirTemperatura();
        }
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            arCondicionado.definirTemperatura(temperatura);
        }
    }
}
