package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;
import org.parte3.Model.Domain.ArCondicionado.ArCondicionadoDesligado;
import org.parte3.Model.Domain.ArCondicionado.ArCondicionadoLigado;
import org.parte3.Model.Domain.ArCondicionado.EstadoArCondicionado;
import org.parte3.Model.Domain.Lampada.EstadoLampada;
import org.parte3.Model.Domain.Lampada.LampadaDesligada;
import org.parte3.Model.Domain.Lampada.LampadaLigada;
import org.parte3.Model.Domain.Persiana.EstadoPersiana;
import org.parte3.Model.Domain.Persiana.PersianaAberta;
import org.parte3.Model.Domain.Persiana.PersianaFechada;

public class HomeFacade {
    private LampadaPhellipes lampadaPhellipes;
    private LampadaShoyuMi  lampadaShoyuMi;
    private PersianaNatLight persianaNatLight;
    private PersianaSolarius persianaSolarius;
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;
    private EstadoPersiana estadoPersiana;
    private EstadoLampada estadoLampada;
    private EstadoArCondicionado estadoArCondicionado;

    public HomeFacade() {
        arCondicionadoGellaKaza = new ArCondicionadoGellaKaza();
        arCondicionadoVentoBaumn = new ArCondicionadoVentoBaumn();
        lampadaPhellipes = new LampadaPhellipes();
        lampadaShoyuMi = new LampadaShoyuMi();
        persianaSolarius = new PersianaSolarius();
        persianaNatLight = new PersianaNatLight();
        estadoPersiana = new PersianaFechada();
        estadoLampada = new LampadaDesligada();
        estadoArCondicionado = new ArCondicionadoDesligado();
    }

    public void modoSono() throws Exception {
        desligarArCondicionados();
        desligarLampadas();
        fecharPersianas();
    }

    public void modoTrabalho() throws Exception {
        acenderLampadas();
        abrirPersianas();
        ligarArCondicionados();
        definirTemperaturaArCondicionado(25);
    }

    public void abrirPersianas() throws Exception {
        estadoPersiana.abrir(persianaNatLight, persianaSolarius);
        estadoPersiana = new PersianaAberta();
    }

    public void fecharPersianas() throws Exception {
        estadoPersiana.fechar(persianaNatLight, persianaSolarius);
        estadoPersiana = new PersianaFechada();
    }

    public void acenderLampadas() {
        estadoLampada.ligar(lampadaPhellipes, lampadaShoyuMi);
        estadoLampada = new LampadaLigada();
    }

    public void desligarLampadas() {
        estadoLampada.desligar(lampadaPhellipes, lampadaShoyuMi);
        estadoLampada = new LampadaDesligada();
    }

    public void ligarArCondicionados() {
        estadoArCondicionado.ligar(arCondicionadoGellaKaza, arCondicionadoVentoBaumn);
        estadoArCondicionado = new ArCondicionadoLigado();
    }

    public void desligarArCondicionados() {
        estadoArCondicionado.desligar(arCondicionadoGellaKaza, arCondicionadoVentoBaumn);
        estadoArCondicionado = new ArCondicionadoDesligado();
    }

    public void aumentarTemperaturaArCondicionados() {
        estadoArCondicionado.aumentarTemperatura(arCondicionadoGellaKaza, arCondicionadoVentoBaumn);
    }

    public void diminuirTemperaturaArCondiconados() {
        estadoArCondicionado.diminuirTemperatura(arCondicionadoGellaKaza, arCondicionadoVentoBaumn);
    }

    public void definirTemperaturaArCondicionado(int temperaturaDesejada) {
        estadoArCondicionado.definirTemperatura(temperaturaDesejada, arCondicionadoGellaKaza, arCondicionadoVentoBaumn);
    }
}



