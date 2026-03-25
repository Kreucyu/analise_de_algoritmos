package org.parte3.Model.Domain.Lampada;

import java.util.List;

public class LampadaContext {
    private List<LampadaCasa> lampadas;
    public LampadaContext(List<LampadaCasa> lampadas) {
        this.lampadas = lampadas;
    }
}
