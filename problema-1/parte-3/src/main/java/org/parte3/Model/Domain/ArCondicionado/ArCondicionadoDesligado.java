package org.parte3.Model.Domain.ArCondicionado;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoDesligado implements EstadoArCondicionado {
    @Override
    public void ligar(ArCondicionadoContext arCondicionadoContext) {
        for (ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            arCondicionado.ligar();
        }
        arCondicionadoContext.setNovoEstado(new ArCondicionadoLigado());
    }

    @Override
    public void desligar(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado já está desligado!");
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado está desligado!");
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado está desligado!");
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado está desligado!");
    }


}
