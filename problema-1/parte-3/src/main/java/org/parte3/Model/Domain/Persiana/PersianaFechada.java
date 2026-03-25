package org.parte3.Model.Domain.Persiana;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class PersianaFechada implements EstadoPersiana {

    @Override
    public void abrir(PersianaContext persianaContext) throws Exception {
        for(PersianaCasa persiana : persianaContext.getPersianas()) {
            persiana.abrir();
        }
        persianaContext.definirNovoEstado(new PersianaAberta());
    }

    @Override
    public void fechar(PersianaContext persianaContext) throws Exception {
        throw new EstadoInvalidoException("A persiana já está fechada!");
    }
}
