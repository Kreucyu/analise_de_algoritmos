package org.parte3.Model.Domain.ArCondicionado;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

import java.util.function.Consumer;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoContext arCondicionadoContext) {
        throw new EstadoInvalidoException("O ar condicionado já está ligado");
    }

    @Override
    public void desligar(ArCondicionadoContext arCondicionadoContext) {
        executarAcao(ArCondicionadoCasa::desligar, arCondicionadoContext);
        arCondicionadoContext.setNovoEstado(new ArCondicionadoDesligado());
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext) {
        executarAcao(ArCondicionadoCasa::aumentarTemperatura, arCondicionadoContext);
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext) {
       executarAcao(ArCondicionadoCasa::diminuirTemperatura, arCondicionadoContext);
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext) {
        executarAcao(ArCondicionado -> ArCondicionado.definirTemperatura(temperatura), arCondicionadoContext);
    }

    public void executarAcao(Consumer<ArCondicionadoCasa> acao, ArCondicionadoContext arCondicionadoContext) {
        for(ArCondicionadoCasa arCondicionado : arCondicionadoContext.getArCondicionados()) {
            acao.accept(arCondicionado);
        }
    }
}
