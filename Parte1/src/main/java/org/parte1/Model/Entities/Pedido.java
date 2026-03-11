package org.parte1.Model.Entities;

import java.util.ArrayList;

public class Pedido {
    private Integer _idPedido;
    private ArrayList<Produto> _listaDeProdutos;

    public Pedido(Integer idPedido) {
        this._idPedido = idPedido;
        this._listaDeProdutos = new ArrayList<>();
    }

    public Integer get_idPedido() {
        return _idPedido;
    }

    public void calcularValorDoPedido() {
        Double pesoDoPedido = calcularPesoDoPedido();
    }

    public Double calcularPesoDoPedido() {
        Double pesoDoPedido = 0.0;
        for (Produto produto : _listaDeProdutos){
            pesoDoPedido += produto.getPesoProduto();
        }
        return pesoDoPedido;
    }
}


