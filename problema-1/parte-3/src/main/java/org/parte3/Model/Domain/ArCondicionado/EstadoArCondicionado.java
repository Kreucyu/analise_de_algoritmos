package org.parte3.Model.Domain.ArCondicionado;

public interface EstadoArCondicionado {
    void ligar(ArCondicionadoContext arCondicionadoContext);
    void desligar(ArCondicionadoContext arCondicionadoContext);
    void aumentarTemperatura(ArCondicionadoContext arCondicionadoContext);
    void diminuirTemperatura(ArCondicionadoContext arCondicionadoContext);
    void definirTemperatura(int temperatura, ArCondicionadoContext arCondicionadoContext);
}
