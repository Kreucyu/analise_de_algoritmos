package org.parte1.Model.Entities;

import org.parte1.Model.Services.CalculadoraDePeso;
import org.parte1.Model.Services.CalculadoraDeValorDoPedido;

import java.util.ArrayList;

public class Pedido {
    private Integer _idPedido;
    private Double _pesoPedido;
    private Double _valorPedido;
    private TiposDeEntrega _tipoDeEntrega;
    private ArrayList<Produto> _listaDeProdutos;

    public Pedido(Integer idPedido, ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega) {
        this._idPedido = idPedido;
        this._listaDeProdutos = produtos;
        this._pesoPedido = CalculadoraDePeso.calcularPeso(_listaDeProdutos);
        this._valorPedido = CalculadoraDeValorDoPedido.calcularValorDoPedido(_listaDeProdutos, _tipoDeEntrega);
        this._tipoDeEntrega = tipoDeEntrega;
    }

    public Integer get_idPedido() {
        return _idPedido;
    }

    public Double get_valorPedido() {
        return _valorPedido;
    }

    public Double get_pesoPedido() {
        return _pesoPedido;
    }

    public TiposDeEntrega get_tipoDeEntrega() {
        return _tipoDeEntrega;
    }

}


