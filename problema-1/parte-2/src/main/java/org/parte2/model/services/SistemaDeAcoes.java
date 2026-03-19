package org.parte2.model.services;

import org.parte2.model.entities.Acao;
import org.parte2.model.entities.Ordem;
import org.parte2.model.entities.TipoOrdem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeAcoes{
    private List<Acao> ListaDeAcoes;

    public SistemaDeAcoes() {
        this.ListaDeAcoes = new ArrayList<>();
    }

    public List<Acao> getListaDeAcao() {
        return this.ListaDeAcoes;
    }

    public void adicionarAcao(Acao acao) {
        this.ListaDeAcoes.add(acao);
    }

    public BigDecimal realizarTransacao(List<Ordem> ordensDeCompra, List<Ordem> ordensDeVenda, Acao acao) {
        for (Ordem ordem : ordensDeCompra) {
            for(Ordem ordem2 : ordensDeVenda){
                OrdensSelecionadas.computeIfAbsent()
            }
            OrdensSelecionadas.put(ordem.getValorOrdem(), ordensDeVenda);
            List<Ordem> ordensFiltradas = OrdensSelecionadas.get(ordem.getValorOrdem());
            if (!ordensFiltradas.isEmpty()) {
                acao.removerOrdem(ordensFiltradas.get(0));
                acao.removerOrdem(ordem);
                return ordem.getValorOrdem();
                }
            }
        return null;
    }
}
