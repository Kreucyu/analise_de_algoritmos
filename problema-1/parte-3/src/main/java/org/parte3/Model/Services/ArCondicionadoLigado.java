package org.parte3.Model.Services;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Exceptions.ArCondicionadoLigadoException;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new ArCondicionadoLigadoException("O Ar Condicionado já está ligado");
    }

    @Override
    public void desligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoVentoBaumn.desligar();
        arCondicionadoGellaKaza.desativar();
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        arCondicionadoGellaKaza.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        arCondicionadoGellaKaza.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoVentoBaumn.definirTemperatura(temperatura);
    }
}
