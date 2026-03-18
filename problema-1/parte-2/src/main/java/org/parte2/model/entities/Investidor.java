package org.parte2.model.entities;

import java.util.Observable;
import java.util.Observer;

public class Investidor implements Observer {
    private String nomeInvestidor;

    public Investidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void registrarOrdem() {
        System.out.println("Qual o tipo da ordem? (compra/venda)");
        Ordem ordem = new Ordem(this.nomeInvestidor, tipoOrdem, valorOrdem);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
