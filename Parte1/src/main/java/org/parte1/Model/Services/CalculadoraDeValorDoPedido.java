package org.parte1.Model.Services;

import org.parte1.Model.Entities.Pedido;
import org.parte1.Model.Entities.Produto;
import org.parte1.Model.Entities.TiposDeEntrega;

import java.util.ArrayList;

public class CalculadoraDeValorDoPedido {

    public Double calcularValorDoPedido(ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega)
    {
        CalculadoraDeValorDeEntrega calculadoraDeValorDeEntrega = new CalculadoraDeValorDeEntrega();
        Double totalPedido = 0.0;
        for (Produto produto : produtos) {
            totalPedido += produto.getValorProduto();
        }
        totalPedido += calculadoraDeValorDeEntrega.calcularEntrega(produtos, tipoDeEntrega);
        return totalPedido;
    }


}
