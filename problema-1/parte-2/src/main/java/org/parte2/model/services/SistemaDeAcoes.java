package org.parte2.model.services;

import org.parte2.model.entities.Acao;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeAcoes {
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
}
