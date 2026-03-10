package org.parte1.Model.Entities;

import java.util.ArrayList;

public class Pedido {
    private Integer _idPedido;
    private Integer _idCliente;
    private ArrayList<Produto> _produtos;

    public Pedido(Integer idPedido, Integer idCliente) {
        this._idPedido = idPedido;
        this._idCliente = idCliente;
    }
}
