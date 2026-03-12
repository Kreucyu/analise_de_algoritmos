package org.parte1.Model.Entities;

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

    public Double calcularValorDoPedido(ArrayList<Produto> produtos, TiposDeEntrega tipoDeEntrega)
    {
        Double totalPedido = 0.0;
        for (Produto produto : produtos) {
            totalPedido += produto.getValorProduto();
        }
        totalPedido += tipoDeEntrega.criar().calcularValorDoEnvio(calcularPeso(produtos));
        return totalPedido;
    }

    public Double calcularPeso(ArrayList<Produto> produtos){
        double pesoTotalDeProdutos = 0.0;
        for(Produto produto : produtos){
            pesoTotalDeProdutos += produto.getPesoProduto();
        }
        return pesoTotalDeProdutos;
    }

    public TiposDeEntrega get_tipoDeEntrega() {
        return _tipoDeEntrega;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("N° " + get_idPedido() + ", ");
        sb.append("Peso: " + String.format("%.2f", calcularPeso(_listaDeProdutos)) + "Kg, ");
        sb.append("Valor: R$" + calcularValorDoPedido(_listaDeProdutos, _tipoDeEntrega));
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


