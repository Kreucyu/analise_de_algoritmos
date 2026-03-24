package org.parte3.Model.Services;

public class PersianaAberta implements EstadoPersiana {
    @Override
    public void abrir() throws Exception {
        throw new PersinadaAbertaException("A persiana já está aberta!");
    }

    @Override
    public void fechar() throws Exception {

    }
}
