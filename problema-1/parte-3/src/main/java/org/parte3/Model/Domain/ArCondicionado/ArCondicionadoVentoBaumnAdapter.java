package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionadoCasa {

    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;

    public ArCondicionadoVentoBaumnAdapter(ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        this.arCondicionadoVentoBaumn = arCondicionadoVentoBaumn;
    }
    @Override
    public void ligar() {
        arCondicionadoVentoBaumn.ligar();
    }

    @Override
    public void desligar() {
        arCondicionadoVentoBaumn.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        int novaTemperatura = arCondicionadoVentoBaumn.getTemperatura() + 1;
        arCondicionadoVentoBaumn.definirTemperatura(novaTemperatura);
    }

    @Override
    public void diminuirTemperatura() {
        int novaTemperatura = arCondicionadoVentoBaumn.getTemperatura() - 1;
        arCondicionadoVentoBaumn.definirTemperatura(novaTemperatura);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionadoVentoBaumn.definirTemperatura(temperatura);
    }
}
