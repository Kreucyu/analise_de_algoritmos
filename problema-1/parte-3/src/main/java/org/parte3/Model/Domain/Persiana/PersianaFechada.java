package org.parte3.Model.Domain.Persiana;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class PersianaFechada implements EstadoPersiana {

    @Override
    public void abrir(PersianaContext persianaContext) {
        for(PersianaCasa persiana : persianaContext.getPersianas()) {
            persiana.abrir();
        }
        persianaContext.setNovoEstado(new PersianaAberta());
    }

    @Override
    public void fechar(PersianaContext persianaContext) {
        throw new EstadoInvalidoException("A persiana já está fechada!");
    }
}
