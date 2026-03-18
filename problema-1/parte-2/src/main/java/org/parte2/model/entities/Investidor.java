package org.parte2.model.entities;

public class Investidor {
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

    public void registrarEmUmaAcao() {
        Acao acao = new Acao();

    }
}
