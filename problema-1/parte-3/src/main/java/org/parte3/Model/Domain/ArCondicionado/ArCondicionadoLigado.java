package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    private ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter;
    private ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter;

    public ArCondicionadoLigado(ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter, ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter) {
        this.arCondicionadoVentoBaumnAdapter = arCondicionadoVentoBaumnAdapter;
        this.arCondicionadoGellaKazaAdapter = arCondicionadoGellaKazaAdapter;
    }


    @Override
    public void ligar() {
        throw new EstadoInvalidoException("O Ar Condicionado já está ligado");
    }

    @Override
    public void desligar() {
        arCondicionadoGellaKazaAdapter.desligar();
        arCondicionadoVentoBaumnAdapter.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionadoVentoBaumnAdapter.aumentarTemperatura();
        arCondicionadoGellaKazaAdapter.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionadoGellaKazaAdapter.diminuirTemperatura();
        arCondicionadoVentoBaumnAdapter.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionadoGellaKazaAdapter.definirTemperatura(temperatura);
        arCondicionadoVentoBaumnAdapter.definirTemperatura(temperatura);
    }
}
