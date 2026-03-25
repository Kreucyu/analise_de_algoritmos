package org.parte3.Model.Domain.ArCondicionado;

import java.util.List;

public class ArCondicionadoContext {
    private List<ArCondicionadoCasa> arCondicionados;
    private EstadoArCondicionado estadoArCondicionado;

    public ArCondicionadoContext(List<ArCondicionadoCasa> arCondicionados) {

        this.arCondicionados = arCondicionados;
        this.estadoArCondicionado = new ArCondicionadoDesligado();
    }

    public void ligar() {
        estadoArCondicionado.ligar(this);
    }

    public void desligar() {
        estadoArCondicionado.desligar(this);
    }

    public void aumentarTemperatura() {
        estadoArCondicionado.aumentarTemperatura(this);
    }

    public void diminuirTemperatura() {
        estadoArCondicionado.diminuirTemperatura(this);
    }

    public void definirTemperatura(int temperatura) {
        estadoArCondicionado.definirTemperatura(temperatura, this);
    }

    public List<ArCondicionadoCasa> getArCondicionados() {
        return this.arCondicionados;
    }

    public void definirNovoEstado(EstadoArCondicionado novoEstado) {
        this.estadoArCondicionado = novoEstado;
    }

}
