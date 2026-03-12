package org.parte1.Model.Entities;

import org.junit.jupiter.api.Test;
import org.parte1.Model.Exceptions.PACIllegalWeightException;
import org.parte1.Model.Services.PACService;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void calcularValorPedidoComSEDEX() {
        Pedido pedido = new Pedido(1, TiposDeEntrega.SEDEX);

        pedido.adicionarProduto(new Produto("Produto 1", 10.0, 0.4));
        pedido.adicionarProduto(new Produto("Produto 2", 20.0, 0.3));

        double valorPedido = pedido.calcularValorDoPedido();

        assertTrue(valorPedido > 30.0, "O valor do pedido com SEDEX deve incluir o frete");
    }

    @Test
    void calcularValorPedidoComPAC() {
        Pedido pedido = new Pedido(2, TiposDeEntrega.PAC);

        pedido.adicionarProduto(new Produto("Produto 1", 10.0, 0.5));
        pedido.adicionarProduto(new Produto("Produto 2", 20.0, 0.5));

        double valorPedido = pedido.calcularValorDoPedido();

        assertTrue(valorPedido > 30.0, "O valor do pedido com PAC deve incluir o frete");
    }

    @Test
    void calcularValorPedidoComRetirada() {
        Pedido pedido = new Pedido(3, TiposDeEntrega.RETIRADA);

        pedido.adicionarProduto(new Produto("Produto 1", 10.0, 1.5));
        pedido.adicionarProduto(new Produto("Produto 2", 20.0, 2.0));

        double valorPedido = pedido.calcularValorDoPedido();

        assertEquals(30.0, valorPedido, "O valor do pedido com retirada não deve ter frete");
    }

    @Test
    void calcularPesoDoPedido() {
        Pedido pedido = new Pedido(4, TiposDeEntrega.RETIRADA);

        pedido.adicionarProduto(new Produto("Produto 1", 10.0, 1.5));
        pedido.adicionarProduto(new Produto("Produto 2", 20.0, 2.0));

        double pesoTotal = pedido.calcularPeso();

        assertEquals(3.5, pesoTotal, "O peso total do pedido deve ser a soma dos pesos dos produtos");
    }

    @Test
    void adicionarEremoverProduto() {
        Pedido pedido = new Pedido(5, TiposDeEntrega.RETIRADA);

        Produto p1 = new Produto("Produto 1", 10.0, 1.0);
        Produto p2 = new Produto("Produto 2", 20.0, 1.5);

        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        assertEquals(2.5, pedido.calcularPeso(), 0.001, "Peso deve ser 2.5Kg após adicionar os produtos");

        pedido.removerProduto(p1);

        assertEquals(1.5, pedido.calcularPeso(), 0.001, "Peso deve ser 1.5Kg após remover p1");
        assertEquals(20.0, pedido.calcularValorDoPedido(), 0.001, "Valor deve ser 20.0 após remover p1");
    }

    @Test
    void calcularValorPedidoPACAcimaDe2KgDeveLancarException() {
        Pedido pedido = new Pedido(7, TiposDeEntrega.PAC);

        pedido.adicionarProduto(new Produto("Produto Pesado", 50.0, 2.5));

        assertThrows(PACIllegalWeightException.class, pedido::calcularValorDoPedido);
    }
}