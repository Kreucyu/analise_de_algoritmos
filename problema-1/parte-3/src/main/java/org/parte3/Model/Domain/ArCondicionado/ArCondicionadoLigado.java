package org.parte3.Model.Domain.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class ArCondicionadoLigado implements EstadoArCondicionado {

    @Override
    public void ligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        throw new EstadoInvalidoException("O Ar Condicionado já está ligado");
    }

    @Override
    public void desligar(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoVentoBaumn.desligar();
        arCondicionadoGellaKaza.desativar();
    }

    @Override
    public void aumentarTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoGellaKaza.aumentarTemperatura();
        int novaTemperatura = arCondicionadoVentoBaumn.getTemperatura() + 1;
        arCondicionadoVentoBaumn.definirTemperatura(novaTemperatura);
    }

    @Override
    public void diminuirTemperatura(ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoGellaKaza.diminuirTemperatura();
        int novaTemperatura = arCondicionadoVentoBaumn.getTemperatura() - 1;
        arCondicionadoVentoBaumn.definirTemperatura(novaTemperatura);
    }

    @Override
    public void definirTemperatura(int temperatura, ArCondicionadoGellaKaza arCondicionadoGellaKaza, ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        arCondicionadoVentoBaumn.definirTemperatura(temperatura);
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
