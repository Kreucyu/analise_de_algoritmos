package org.parte2.model.entities;

import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;
import java.util.*;

public class Acao extends Observable {
    private String nomeAcao;
    private BigDecimal valorAcao;
    private List<Ordem> listaDeOrdens;
    private SistemaDeAcoes sistemaDeAcoes;

    public Acao(String nomeAcao, BigDecimal valorAcao) {
        this.nomeAcao = nomeAcao;
        this.valorAcao = valorAcao;
        this.listaDeOrdens = new ArrayList<>();
        this.sistemaDeAcoes = new SistemaDeAcoes();
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public BigDecimal getValorAcao() {
        return valorAcao;
    }

    public List<Ordem> getListaDeOrdens() {
        return listaDeOrdens;
    }

    public void adicionarOrdem(Ordem ordem) {
        this.listaDeOrdens.add(ordem);
        BigDecimal valorAcao = sistemaDeAcoes.realizarTransacao(this);
        if (valorAcao != null) {
            this.valorAcao = valorAcao;
            setChanged();
            notifyObservers(valorAcao);
        }

    }

    public void removerOrdem(Ordem ordem) {
        this.listaDeOrdens.remove(ordem);
    }

    public List<Ordem> getOrdensDeCompra() {
        List<Ordem> ordensDeCompra = this.listaDeOrdens.stream()
                .filter(ordem -> ordem.getTipoOrdem().equals(TipoOrdem.COMPRA))
                .toList();
        return ordensDeCompra;
    }

    public Map<BigDecimal, List<Ordem>> getOrdensDeVenda() {
        Map<BigDecimal, List<Ordem>> ordensDeVenda = new HashMap<>();
        for (Ordem ordem : this.listaDeOrdens) {
            if(ordem.getTipoOrdem().equals(TipoOrdem.VENDA)){
                ordensDeVenda
                        .computeIfAbsent(ordem.getValorOrdem(), k -> new ArrayList<>())
                        .add(ordem);
            }
        }
        return ordensDeVenda;
    }

    @Override
    public String toString() {
        return "Acao{" +
                "nomeAcao='" + nomeAcao + '\'' +
                ", valorAcao=" + valorAcao +
                ", listaDeOrdens=" + listaDeOrdens +
                '}';
    }
}
