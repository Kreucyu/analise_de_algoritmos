package org.parte1.Model.Entities;

public class Produto {
    private String _nomeProduto;
    private Double _valorProduto;
    private Double _pesoProduto;

    public Produto(String nomeProduto, Double valorProduto, Double pesoProduto) {
        this._nomeProduto = nomeProduto;
        this._valorProduto = valorProduto;
        this._pesoProduto = pesoProduto;
    }

    public String getNomeProduto() {
        return _nomeProduto;
    }

    public Double getValorProduto() {
        return _valorProduto;
    }

    public Double getPesoProduto() {
        return _pesoProduto;
    }

    @Override
    public String toString() {
        return _nomeProduto + ", R$" + _valorProduto + ", " + _pesoProduto + "Kg";
    }
}
