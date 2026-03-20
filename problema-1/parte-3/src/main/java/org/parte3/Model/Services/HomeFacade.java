package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;
import org.parte3.Model.Entities.ArCondicionadoFuncoes;
import org.parte3.Model.Entities.LampadaFuncoes;
import org.parte3.Model.Entities.PersianasFuncoes;

public class HomeFacade {
    private LampadaPhellipes lampadaPhellipes;
    private LampadaShoyuMi  lampadaShoyuMi;
    private PersianaNatLight persianaNatLight;
    private PersianaSolarius persianaSolarius;
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;

    public HomeFacade(LampadaPhellipes lampadaPhellipes, LampadaShoyuMi lampadaShoyuMi,
                      PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius,
                      ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        this.arCondicionadoGellaKaza = arCondicionadoGellaKaza;
        this.arCondicionadoVentoBaumn = arCondicionadoVentoBaumn;
        this.lampadaPhellipes = lampadaPhellipes;
        this.lampadaShoyuMi = lampadaShoyuMi;
        this.persianaSolarius = persianaSolarius;
        this.persianaNatLight = persianaNatLight;
    }

    public void modoSono() {

    }

    public void modoTrabalho() {

    }

    public void controlarPersianas(PersianasFuncoes funcaoPersiana) throws Exception {
        if(funcaoPersiana == PersianasFuncoes.ABRIR) {
            if(!persianaSolarius.estaAberta()) {
                persianaSolarius.subirPersiana();
            }
            if(!persianaNatLight.estaPalhetaErguida()) {
                if (!persianaNatLight.estaPalhetaAberta()) {
                    persianaNatLight.abrirPalheta();
                }
                persianaNatLight.subirPalheta();
            }
        }
        if(persianaSolarius.estaAberta()) {
            persianaSolarius.descerPersiana();
        }
        if(persianaNatLight.estaPalhetaAberta()) {
            if (persianaNatLight.estaPalhetaErguida()) {
                persianaNatLight.descerPalheta();
            }
            persianaNatLight.fecharPalheta();
        }
    }

    public void controlarLampadas(LampadaFuncoes funcaoLampada) {
    if(funcaoLampada == LampadaFuncoes.LIGAR) {
        if(!lampadaShoyuMi.estaLigada()) {
            lampadaShoyuMi.ligar();
        }
        if(lampadaPhellipes.getIntensidade() == 0) {
            lampadaPhellipes.setIntensidade(100);
        }
    }
    }

    public void controlarArCondicionados(ArCondicionadoFuncoes funcaoArCondicionado) {

    }
}



