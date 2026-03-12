package org.parte1.Model.Services;

public class RETIRADAService implements TipoEntrega{
    private static final double VALOR_RETIRADA = 0.0;
    @Override
    public Double calcularValorDoEnvio(Double PesoPedido){
        return VALOR_RETIRADA;
    }
}
