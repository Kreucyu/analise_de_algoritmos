package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

import java.util.List;

public class ArCondicionadoContext {
    private List<ArCondicionadoCasa> arCondicionados;


    public ArCondicionadoContext(List<ArCondicionadoCasa> arCondicionados) {
        this.arCondicionados = arCondicionados;
    }
}
