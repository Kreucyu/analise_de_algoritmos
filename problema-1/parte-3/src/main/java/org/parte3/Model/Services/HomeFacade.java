package org.parte3.Model.Services;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.parte3.Model.Domain.ArCondicionado.*;
import org.parte3.Model.Domain.Lampada.*;
import org.parte3.Model.Domain.Persiana.*;

import java.util.List;

public class HomeFacade {
    private ArCondicionadoContext arCondicionadoContext;
    private LampadaContext lampadaContext;
    private PersianaContext persianaContext;

    public HomeFacade() {
        arCondicionadoContext = new ArCondicionadoContext(List.of(new ArCondicionadoVentoBaumnAdapter(new ArCondicionadoVentoBaumn()),
                new ArCondicionadoGellaKazaAdapter(new ArCondicionadoGellaKaza())));
        lampadaContext = new LampadaContext(List.of(new LampadaPhellipesAdapter(new LampadaPhellipes()),
                new LampadaShoyuMiAdapter(new LampadaShoyuMi())));
        persianaContext = new PersianaContext(List.of(new PersianaSolariusAdapter(new PersianaSolarius()),
                new PersianaNatLightAdapter(new PersianaNatLight())));
    }

    public void modoSono() throws Exception {
        desligarArCondicionados();
        desligarLampadas();
        fecharPersianas();
    }

    public void modoTrabalho() throws Exception {
        ligarLampadas();
        abrirPersianas();
        ligarArCondicionados();
        int temperaturaModoTrabalho = 25;
        definirTemperaturaArCondicionado(temperaturaModoTrabalho);
    }

    public void abrirPersianas() throws Exception {
        persianaContext.abrir();
    }

    public void fecharPersianas() throws Exception {
        persianaContext.fechar();
    }

    public void ligarLampadas() {
        lampadaContext.ligar();
    }

    public void desligarLampadas() {
        lampadaContext.desligar();
    }

    public void ligarArCondicionados() {
        arCondicionadoContext.ligar();
    }

    public void desligarArCondicionados() {
        arCondicionadoContext.desligar();
    }

    public void aumentarTemperaturaArCondicionados() {
        arCondicionadoContext.aumentarTemperatura();
    }

    public void diminuirTemperaturaArCondiconados() {
        arCondicionadoContext.diminuirTemperatura();
    }

    public void definirTemperaturaArCondicionado(int temperaturaDesejada) {
        arCondicionadoContext.definirTemperatura(temperaturaDesejada);
    }
}



