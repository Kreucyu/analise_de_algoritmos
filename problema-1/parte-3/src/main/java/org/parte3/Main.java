package org.parte3;

import br.furb.analise.algoritmos.*;
import org.parte3.Model.Services.HomeFacade;

public class Main {
    public static void main(String[] args) {

        HomeFacade homeFacade = new HomeFacade(new LampadaPhellipes(), new LampadaShoyuMi(),
                new PersianaNatLight(), new PersianaSolarius(),
                new ArCondicionadoGellaKaza(), new ArCondicionadoVentoBaumn());

    }
}