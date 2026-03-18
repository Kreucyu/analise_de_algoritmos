package org.parte2.model.entities;

import org.parte2.model.services.SistemaDeAcoes;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Investidor implements Observer {
    private String nomeInvestidor;

    public Investidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void registrarOrdem(TipoOrdem tipoOrdem, BigDecimal valorAcao) {
        Ordem ordem = new Ordem(getNomeInvestidor(), tipoOrdem, valorAcao);
    }

    public void registrarEmUmaAcao() {
        Scanner sc = new Scanner(System.in);
        SistemaDeAcoes acoes = new SistemaDeAcoes();
        acoes.getListaDeAcao().stream().forEach(acao -> acao.toString());
        System.out.println("Digite o nome da ação desejada: ");
        String nomeEscolhido = sc.nextLine();
        for (Acao acao : acoes.getListaDeAcao()) {
            if (acao.getNomeAcao().equals(nomeEscolhido)) {
                acao.addObserver(this);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("A Ação " + o + ", teve seu valor alterado para: R$" + arg);
    }

    @Override
    public String toString() {
        return "Investidor{" +
                "nomeInvestidor='" + nomeInvestidor + '\'' +
                '}';
    }
}
