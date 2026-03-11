package org.parte1.Model.Services;

import org.parte1.Model.Entities.Produto;

import java.util.ArrayList;

public class CalculadoraDePeso {

    public Double calcularPeso(ArrayList<Produto> produtos){
        double pesoTotalDeProdutos = 0.0;
        for(Produto produto : produtos){
            pesoTotalDeProdutos += produto.getPesoProduto();
        }
        return pesoTotalDeProdutos;
    }
}
