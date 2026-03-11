package org.parte1.Model.Services;

import org.parte1.Model.Entities.Produto;
import org.parte1.Model.Entities.TiposDeEntrega;

import java.util.ArrayList;

public class CalculadoraDeValorDeEntrega {

    public static Double calcularEntrega(ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega)
    {
        double valorDaEntrega = 0.0;
        switch (tipoDeEntrega) {
            case SEDEX -> {
                valorDaEntrega = SEDEXService.calcularValorDoEnvio(CalculadoraDePeso.calcularPeso(produtos));
                return valorDaEntrega;
            }
            case PAC -> {
                valorDaEntrega = PACService.calcularValorDoEnvio(CalculadoraDePeso.calcularPeso(produtos));
                return valorDaEntrega;
            }
            case RETIRADA -> {
                return valorDaEntrega;
            }
            default -> {
                return 0.0;
            }
        }
    }
}
