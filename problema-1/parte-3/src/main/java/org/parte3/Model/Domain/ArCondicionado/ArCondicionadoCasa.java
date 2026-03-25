package org.parte3.Model.Domain.ArCondicionado;

import java.util.function.Consumer;

public interface ArCondicionadoCasa {
    void ligar();
    void desligar();
    void aumentarTemperatura();
    void diminuirTemperatura();
    void definirTemperatura(int temperatura);
}
