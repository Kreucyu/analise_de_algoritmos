package org.parte1.Model.Exceptions;

public class PACIllegalWeightException extends RuntimeException {
    public PACIllegalWeightException() {
        super("Encomendas PAC não aceitam pedidos acima de 2Kg");
    }
}
