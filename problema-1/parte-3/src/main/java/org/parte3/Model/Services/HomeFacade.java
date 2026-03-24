package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;

public class HomeFacade {
    private LampadaPhellipes lampadaPhellipes;
    private LampadaShoyuMi  lampadaShoyuMi;
    private PersianaNatLight persianaNatLight;
    private PersianaSolarius persianaSolarius;
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;

    public HomeFacade() {
        arCondicionadoGellaKaza = new ArCondicionadoGellaKaza();
        arCondicionadoVentoBaumn = new ArCondicionadoVentoBaumn();
        lampadaPhellipes = new LampadaPhellipes();
        lampadaShoyuMi = new LampadaShoyuMi();
        persianaSolarius = new PersianaSolarius();
        persianaNatLight = new PersianaNatLight(); }

    public void modoSono() {

    }

    public void modoTrabalho() {
    }

    public void abrirPersianas() throws Exception {
        if(!persianaNatLight.estaPalhetaAberta()){
            persianaNatLight.abrirPalheta();
        }
        persianaNatLight.subirPalheta();
        persianaSolarius.subirPersiana();
    }

    public void fecharPersianas() throws Exception {
        if(persianaNatLight.estaPalhetaErguida()){
            persianaNatLight.descerPalheta();
        }
        persianaNatLight.fecharPalheta();
        persianaSolarius.descerPersiana();
    }

    public void acenderLampadas() {
        lampadaPhellipes.setIntensidade(100);
        lampadaShoyuMi.ligar();
    }

    public void desligarLampadas() {
        lampadaPhellipes.setIntensidade(0);
        lampadaShoyuMi.desligar();
    }

}



