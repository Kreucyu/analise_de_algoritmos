package org.parte1.Model.Entities;

import org.parte1.Model.Services.TipoEntrega;

import java.util.ArrayList;

public class Pedido {
    private Integer _idPedido;
    private TiposDeEntrega _tipoDeEntrega;
    private ArrayList<Produto> _listaDeProdutos = new ArrayList<>();

    public Pedido(Integer idPedido, TiposDeEntrega tipoDeEntrega) {
        this._idPedido = idPedido;
        this._tipoDeEntrega = tipoDeEntrega;
    }

    public Integer get_idPedido() {
        return _idPedido;
    }

    public void adicionarProduto(Produto produto) {
        this._listaDeProdutos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this._listaDeProdutos.remove(produto);
    }

    public Double calcularValorDoPedido()
    {
        Double totalPedido = 0.0;
        for (Produto produto : _listaDeProdutos) {
            totalPedido += produto.getValorProduto();
        }
        TipoEntrega entrega = _tipoDeEntrega.criar();
        totalPedido += entrega.calcularValorDoEnvio(calcularPeso());
        return totalPedido;
    }

    public Double calcularPeso(){
        double pesoTotalDeProdutos = 0.0;
        for(Produto produto : _listaDeProdutos){
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
        sb.append("N° ").append(get_idPedido()).append(", ");
        sb.append("Peso: ").append(calcularPeso()).append("Kg, ");
        sb.append("Valor: R$").append(calcularValorDoPedido());
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


