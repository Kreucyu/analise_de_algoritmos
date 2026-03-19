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

    public BigDecimal realizarTransacao(List<Ordem> ordensDeCompra, Map<BigDecimal, List<Ordem>> ordensDeVenda, Acao acao) {
        for (Ordem ordem : ordensDeCompra) {
            List<Ordem> vendasPossiveis = ordensDeVenda.get(ordem.getValorOrdem());
            if(vendasPossiveis == null){
                continue;
            }
            Ordem vendaSelecionada = vendasPossiveis
                    .stream()
                    .filter(venda -> !venda.getNomeInvestidor().equals(ordem.getNomeInvestidor()))
                    .findFirst()
                    .orElse(null);
            if(vendaSelecionada == null) {
                continue;
            }
                acao.removerOrdem(vendaSelecionada);
                acao.removerOrdem(ordem);
                return  ordem.getValorOrdem();
        }
        return null;
    }
}
