package org.parte3.Model.Services;

import br.furb.analise.algoritmos.*;

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
}



