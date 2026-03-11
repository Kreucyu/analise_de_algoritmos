package org.parte1.Application;

import org.parte1.Model.Entities.Pedido;
import org.parte1.Model.Entities.Produto;
import org.parte1.Model.Entities.TiposDeEntrega;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("O Senhor dos Anéis", 20.0, 0.3);
        Produto produto2 = new Produto("Holly", 30.0, 0.4);
        Produto produto3 = new Produto("Alice no País das Maravilhas", 15.0, 0.2);
        Produto produto4 = new Produto("It a Coisa", 50.0, 0.8);

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        Pedido pedido1 = new Pedido(1, produtos, TiposDeEntrega.SEDEX);
        System.out.println(pedido1.toString());
        Pedido pedido2 = new Pedido(2, produtos, TiposDeEntrega.PAC);
        System.out.println(pedido2.toString());
        Pedido pedido3 = new Pedido(3, produtos, TiposDeEntrega.RETIRADA);
        System.out.println(pedido3.toString());


    }
}