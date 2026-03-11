package org.parte1.Model.Services;

import org.parte1.Model.Entities.Produto;
import org.parte1.Model.Entities.TiposDeEntrega;

import java.util.ArrayList;

public class CalculadoraDeValorDeEntrega {

    public Double calcularEntrega(ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega)
    {
        double valorDaEntrega = 0.0;
        CalculadoraDePeso calculadoraDePeso = new CalculadoraDePeso();
        switch (tipoDeEntrega) {
            case SEDEX -> {
                SEDEXService envio = new SEDEXService();
                valorDaEntrega = envio.calcularValorDoEnvio(calculadoraDePeso.calcularPeso(produtos));
                return valorDaEntrega;
            }
            case PAC -> {
                PACService envio = new PACService();
                valorDaEntrega = envio.calcularValorDoEnvio(calculadoraDePeso.calcularPeso(produtos));
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
