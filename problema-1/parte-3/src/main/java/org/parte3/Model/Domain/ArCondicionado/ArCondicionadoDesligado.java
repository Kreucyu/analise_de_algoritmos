package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoDesligado implements EstadoArCondicionado {

    private ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter;
    private ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter;

    public ArCondicionadoDesligado(ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter, ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter) {
        this.arCondicionadoVentoBaumnAdapter = arCondicionadoVentoBaumnAdapter;
        this.arCondicionadoGellaKazaAdapter = arCondicionadoGellaKazaAdapter;
    }

    @Override
    public void ligar() {
        arCondicionadoGellaKazaAdapter.ligar();
        arCondicionadoVentoBaumnAdapter.ligar();
    }

    @Override
    public void desligar() {
        throw new EstadoInvalidoException("O Ar Condicionado já está desligado!");
    }

    @Override
    public void aumentarTemperatura() {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void diminuirTemperatura() {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }

    @Override
    public void definirTemperatura(int temperatura) {
        throw new EstadoInvalidoException("O Ar Condicionado está desligado!");
    }
}
