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

        Pedido pedido1 = new Pedido(1, TiposDeEntrega.SEDEX);
        pedido1.adicionarProduto(produto1);
        pedido1.adicionarProduto(produto2);
        pedido1.adicionarProduto(produto3);
        pedido1.adicionarProduto(produto4);
        System.out.println(pedido1.toString());

        Pedido pedido2 = new Pedido(2,TiposDeEntrega.PAC);
        pedido2.adicionarProduto(produto1);
        pedido2.adicionarProduto(produto2);
        pedido2.adicionarProduto(produto3);
        pedido2.adicionarProduto(produto4);
        System.out.println(pedido2.toString());

        Pedido pedido3 = new Pedido(3,TiposDeEntrega.RETIRADA);
        pedido3.adicionarProduto(produto1);
        pedido3.adicionarProduto(produto2);
        pedido3.adicionarProduto(produto3);
        pedido3.adicionarProduto(produto4);
        System.out.println(pedido3.toString());


    }
}
