package org.parte1.Model.Services;

import org.parte1.Model.Exceptions.PACIllegalWeightException;

public class PACService implements TipoEntrega {
    private static final double UM_QUILO = 1.0;
    private static final double DOIS_QUILOS = 2.0;
    private static final double PRECO_ATE_UM_QUILO = 10.0;
    private static final double PRECO_ATE_DOIS_QUILOS = 15.0;

    @Override
    public Double calcularValorDoEnvio(Double PesoPedido) {
        double valorEnvio = 0.0;

        if (PesoPedido <= UM_QUILO) {
            valorEnvio = PRECO_ATE_UM_QUILO;
            return valorEnvio;
        }
        if (PesoPedido >= UM_QUILO && PesoPedido <= DOIS_QUILOS) {
            valorEnvio = PRECO_ATE_DOIS_QUILOS;
            return valorEnvio;
        }
        throw new PACIllegalWeightException();
    }
}


