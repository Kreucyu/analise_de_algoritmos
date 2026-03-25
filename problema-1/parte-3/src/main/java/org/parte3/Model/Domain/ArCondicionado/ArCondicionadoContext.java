package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoContext {
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;
    private EstadoArCondicionado estadoArCondicionado;

    public ArCondicionadoContext() {
        this.arCondicionadoGellaKaza = new ArCondicionadoGellaKaza();
        this.arCondicionadoVentoBaumn = new ArCondicionadoVentoBaumn();
        this.estadoArCondicionado = new ArCondicionadoDesligado();
    }


}
