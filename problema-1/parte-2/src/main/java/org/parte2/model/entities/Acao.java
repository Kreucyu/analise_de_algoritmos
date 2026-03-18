package org.parte2.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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

    public List<Ordem> getListaDeOrdens() {
        return listaDeOrdens;
    }

    public void adicionarOrdem(Ordem ordem) {
        this.listaDeOrdens.add(ordem);
        realizarTransacao(ordem);
    }

    private void removerOrdem(Ordem ordem) {
        this.listaDeOrdens.remove(ordem);

    }

    private void realizarTransacao(Ordem ordem) {
        for (Ordem ordens : this.listaDeOrdens) {
            if(ordem.getValorOrdem().equals(ordem.getValorOrdem()) && !(ordem.getTipoOrdem().equals(ordem.getTipoOrdem()))) {
                System.out.println("Transação efetuada com sucesso!");
                this.valorAcao = ordem.getValorOrdem();
                setChanged();
                removerOrdem(ordem);
                removerOrdem(ordens);
                break;
            }
        }
        if (hasChanged()) {
            notifyObservers(getValorAcao());
        }
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
