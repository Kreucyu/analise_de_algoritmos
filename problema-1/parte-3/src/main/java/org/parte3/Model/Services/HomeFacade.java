package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;
import org.parte3.Model.Domain.ArCondicionado.*;
import org.parte3.Model.Domain.Lampada.*;
import org.parte3.Model.Domain.Persiana.*;

public class HomeFacade {
    private LampadaPhellipesAdapter lampadaPhellipesAdapter;
    private LampadaShoyuMiAdapter lampadaShoyuMiAdapter;
    private PersianaNatLightAdapter persianaNatLightAdapter;
    private PersianaSolariusAdapter persianaSolariusAdapter;
    private ArCondicionadoGellaKazaAdapter arCondicionadoGellaKazaAdapter;
    private ArCondicionadoVentoBaumnAdapter arCondicionadoVentoBaumnAdapter;

    public HomeFacade() {
        arCondicionadoGellaKazaAdapter = new ArCondicionadoGellaKazaAdapter(new ArCondicionadoGellaKaza());
        arCondicionadoVentoBaumnAdapter = new ArCondicionadoVentoBaumnAdapter(new ArCondicionadoVentoBaumn());
        lampadaPhellipesAdapter = new LampadaPhellipesAdapter(new LampadaPhellipes());
        lampadaShoyuMiAdapter = new LampadaShoyuMiAdapter(new LampadaShoyuMi());
        persianaSolariusAdapter = new PersianaSolariusAdapter(new PersianaSolarius());
        persianaNatLightAdapter = new PersianaNatLightAdapter(new PersianaNatLight());
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

    }

    public void fecharPersianas() throws Exception {

    }

    public void acenderLampadas() {

    }

    public void desligarLampadas() {

    }

    public void ligarArCondicionados() {

    }

    public void desligarArCondicionados() {

    }

    public void aumentarTemperaturaArCondicionados() {

    }

    public void diminuirTemperaturaArCondiconados() {

    }

    public void definirTemperaturaArCondicionado(int temperaturaDesejada) {

    }
}



