package org.parte1.Model.Entities;

import org.junit.jupiter.api.Test;
import org.parte1.Model.Services.PACService;
import org.parte1.Model.Services.SEDEXService;
import org.parte1.Model.Services.RETIRADAService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void calcularValorPedidoComSEDEX() {
        Produto produto1 = new Produto("Produto 1", 10.0, 1.5);
        Produto produto2 = new Produto("Produto 2", 20.0, 2.0);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Pedido pedido = new Pedido(1, produtos, TiposDeEntrega.SEDEX);

        double valorPedido = pedido.calcularValorDoPedido(produtos, TiposDeEntrega.SEDEX);

        assertTrue(valorPedido > 0, "O valor do pedido com SEDEX deve ser maior que 0");
    }

    @Test
    void calcularValorPedidoComPAC() {
        Produto produto1 = new Produto("Produto 1", 10.0, 1.5);
        Produto produto2 = new Produto("Produto 2", 20.0, 2.0);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Pedido pedido = new Pedido(2, produtos, TiposDeEntrega.PAC);

        double valorPedido = pedido.calcularValorDoPedido(produtos, TiposDeEntrega.PAC);

        assertTrue(valorPedido > 0, "O valor do pedido com PAC deve ser maior que 0");
    }

    @Test
    void calcularValorPedidoComRetirada() {
        Produto produto1 = new Produto("Produto 1", 10.0, 1.5);
        Produto produto2 = new Produto("Produto 2", 20.0, 2.0);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Pedido pedido = new Pedido(3, produtos, TiposDeEntrega.RETIRADA);

        double valorPedido = pedido.calcularValorDoPedido(produtos, TiposDeEntrega.RETIRADA);

        assertEquals(30.0, valorPedido, "O valor do pedido com Retirada deve ser o valor dos produtos, sem custo de envio");
    }
}