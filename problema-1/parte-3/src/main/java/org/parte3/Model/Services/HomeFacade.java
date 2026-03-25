package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;
import org.parte3.Model.Domain.ArCondicionado.*;
import org.parte3.Model.Domain.Lampada.*;
import org.parte3.Model.Domain.Persiana.*;

import java.util.List;

public class HomeFacade {
    private LampadaPhellipesAdapter lampadaPhellipesAdapter;
    private LampadaShoyuMiAdapter lampadaShoyuMiAdapter;
    private PersianaNatLightAdapter persianaNatLightAdapter;
    private PersianaSolariusAdapter persianaSolariusAdapter;
    private ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter;
    private ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter;
    private ArCondicionadoContext arCondicionadoContext;
    private LampadaContext lampadaContext;
    private PersianaContext persianaContext;

    public HomeFacade() {
        arCondicionadoGellaKazaAdapter = new ArCondicionadoGellaKazaAdapter(new ArCondicionadoGellaKaza());
        arCondicionadoVentoBaumnAdapter = new ArCondicionadoVentoBaumnAdapter(new ArCondicionadoVentoBaumn());
        lampadaPhellipesAdapter = new LampadaPhellipesAdapter(new LampadaPhellipes());
        lampadaShoyuMiAdapter = new LampadaShoyuMiAdapter(new LampadaShoyuMi());
        persianaSolariusAdapter = new PersianaSolariusAdapter(new PersianaSolarius());
        persianaNatLightAdapter = new PersianaNatLightAdapter(new PersianaNatLight());
        arCondicionadoContext = new ArCondicionadoContext(List.of(arCondicionadoVentoBaumnAdapter, arCondicionadoGellaKazaAdapter));
        lampadaContext = new LampadaContext(List.of(lampadaPhellipesAdapter, lampadaShoyuMiAdapter));
        persianaContext = new PersianaContext(List.of(persianaSolariusAdapter, persianaNatLightAdapter));
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
        definirTemperaturaArCondicionado(25);
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
        arCondicionadoContext.definirTemperatura(temperatura);
    }
}



