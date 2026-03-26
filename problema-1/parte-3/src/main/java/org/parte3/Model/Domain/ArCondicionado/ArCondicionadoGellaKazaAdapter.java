package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionadoCasa{
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;

    public ArCondicionadoGellaKazaAdapter(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        this.arCondicionadoGellaKaza = arCondicionadoGellaKaza;
    }

    @Override
    public void ligar() {
        arCondicionadoGellaKaza.ativar();
    }

    @Override
    public void desligar() {
        arCondicionadoGellaKaza.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionadoGellaKaza.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionadoGellaKaza.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        int sentidoAjuste = arCondicionadoGellaKaza.getTemperatura() - temperatura;
        while(arCondicionadoGellaKaza.getTemperatura() != temperatura) {
            ajustarTemperatura(sentidoAjuste, arCondicionadoGellaKaza);
        }
    }

    private void ajustarTemperatura(int sentidoAjuste, ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        if(sentidoAjuste < 0) {
            arCondicionadoGellaKaza.aumentarTemperatura();
            return;
        }
        arCondicionadoGellaKaza.diminuirTemperatura();
    }
}
