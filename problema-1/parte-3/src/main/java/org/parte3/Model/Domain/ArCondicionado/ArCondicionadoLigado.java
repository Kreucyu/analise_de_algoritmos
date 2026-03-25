package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado já está ligado");
    }

    @Override
    public void desligar(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.listarArCondicionados()) {
            arCondicionado.desligar();
        }
        arCondicionadoContext.definirNovoEstado(new ArCondicionadoDesligado());
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.listarArCondicionados()) {
            arCondicionado.aumentarTemperatura();
        }
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.listarArCondicionados()) {
            arCondicionado.diminuirTemperatura();
        }
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.listarArCondicionados()) {
            arCondicionado.definirTemperatura(temperatura);
        }
    }
}
