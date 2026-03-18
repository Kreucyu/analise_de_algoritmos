package org.parte2.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Acao {
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
        valorAcao = ordem.getValorOrdem();
    }


}
