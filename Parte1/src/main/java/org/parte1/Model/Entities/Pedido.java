package org.parte1.Model.Entities;

import org.parte1.Model.Services.CalculadoraDePeso;
import org.parte1.Model.Services.CalculadoraDeValorDoPedido;

import java.util.ArrayList;

public class Pedido {
    private Integer _idPedido;
    private TiposDeEntrega _tipoDeEntrega;
    private ArrayList<Produto> _listaDeProdutos;

    public Pedido(Integer idPedido, ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega) {
        this._idPedido = idPedido;
        this._listaDeProdutos = produtos;
        this._tipoDeEntrega = tipoDeEntrega;
    }

    public Integer get_idPedido() {
        return _idPedido;
    }

    public Double get_valorPedido() {
        CalculadoraDeValorDoPedido calculadora = new CalculadoraDeValorDoPedido();
        return calculadora.calcularValorDoPedido(_listaDeProdutos, _tipoDeEntrega);
    }

    public Double get_pesoPedido() {
        CalculadoraDePeso calculadora = new CalculadoraDePeso();
        return calculadora.calcularPeso(_listaDeProdutos);
    }

    public TiposDeEntrega get_tipoDeEntrega() {
        return _tipoDeEntrega;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("N° " + _idPedido + ", ");
        sb.append("Peso: " + String.format("%.2f", get_pesoPedido()) + "Kg, ");
        sb.append("Valor: R$" + get_valorPedido());
        sb.append("\nLista de produtos: ");
        int counter = 0;
        for (Produto produto : _listaDeProdutos) {
            if(counter != 0){
                sb.append(", ");
            }
            sb.append(produto.toString());
            counter++;
        }
        return sb.toString();
    }
}


