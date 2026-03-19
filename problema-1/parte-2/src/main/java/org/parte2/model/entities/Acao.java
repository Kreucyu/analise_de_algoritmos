package org.parte2.model.entities;

import java.math.BigDecimal;
import java.util.*;

public class Acao extends Observable {

    private String nomeAcao;
    private BigDecimal valorAcao;
    private List<Ordem> listaDeOrdens;

    public Acao(String nomeAcao, BigDecimal valorAcao) {
        this.nomeAcao = nomeAcao;
        this.valorAcao = valorAcao;
        this.listaDeOrdens = new ArrayList<>();
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public BigDecimal getValorAcao() {
        return valorAcao;
    }

    public List<Ordem> listarOrdens() {
        return Collections.unmodifiableList(listaDeOrdens);
    }

    public void adicionarOrdem(Ordem ordem) {
        this.listaDeOrdens.add(ordem);
    }

    public void removerOrdem(Ordem ordem) {
        this.listaDeOrdens.remove(ordem);
    }

    public List<Ordem> getOrdensDeCompra() {
        return listaDeOrdens.stream()
                .filter(o -> o.getTipoOrdem() == TipoOrdem.COMPRA)
                .toList();
    }

    public Map<BigDecimal, List<Ordem>> getOrdensDeVenda() {
        Map<BigDecimal, List<Ordem>> ordens = new HashMap<>();

        for (Ordem ordem : listaDeOrdens) {
            if (ordem.getTipoOrdem() == TipoOrdem.VENDA) {
                ordens.computeIfAbsent(ordem.getValorOrdem(), k -> new ArrayList<>())
                        .add(ordem);
            }
        }

        return ordens;
    }

    public void atualizarValor(BigDecimal novoValor) {
        this.valorAcao = novoValor;
        setChanged();
        notifyObservers(novoValor);
    }

    @Override
    public String toString() {
        return "Acao{" +
                "nomeAcao='" + nomeAcao + '\'' +
                ", valorAcao=" + valorAcao +
                '}';
    }
}