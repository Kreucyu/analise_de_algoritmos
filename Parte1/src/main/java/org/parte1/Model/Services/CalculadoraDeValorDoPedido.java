package org.parte1.Model.Services;

import org.parte1.Model.Entities.Pedido;
import org.parte1.Model.Entities.Produto;
import org.parte1.Model.Entities.TiposDeEntrega;

import java.util.ArrayList;

public class CalculadoraDeValorDoPedido {

    public static Double calcularValorDoPedido(ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega)
    {
        Double totalPedido = 0.0;
        for (Produto produto : produtos) {
            totalPedido += produto.getValorProduto();
        }
        totalPedido += CalculadoraDeValorDeEntrega.calcularEntrega(produtos, tipoDeEntrega);
        return totalPedido;
    }


}
