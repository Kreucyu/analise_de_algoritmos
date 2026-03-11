package org.parte1.Model.Services;

public class SEDEXService implements TipoEntrega {
    private static final double UM_QUILO = 1.0;
    private static final double QUINTENTOS_GRAMA = 0.5;
    private static final double PRECO_ATE_QUINHENTOS_GRAMA = 12.5;
    private static final double PRECO_ATE_UM_QUILO = 20.0;
    private static final double ADICIONAL = 0.1;
    private static final double PRECO_ACIMA_DE_UM_QUILO = 46.50;

    @Override
    public Double calcularValorDoEnvio(Double PesoPedido) {
        double valorEnvio = 0.0;
        if(PesoPedido <= QUINTENTOS_GRAMA){
            valorEnvio = PRECO_ATE_QUINHENTOS_GRAMA;
            return valorEnvio;
        }

        if(PesoPedido >= QUINTENTOS_GRAMA && PesoPedido <= UM_QUILO){
            valorEnvio = PRECO_ATE_UM_QUILO;
            return valorEnvio;
        }
        valorEnvio = PRECO_ACIMA_DE_UM_QUILO;
        if(PesoPedido > UM_QUILO + ADICIONAL){
            double valorAdicional = Math.round((PesoPedido - UM_QUILO) / ADICIONAL) * 1.5;
            valorEnvio += valorAdicional;
            return valorEnvio;
        }
        return valorEnvio;
    }
}
