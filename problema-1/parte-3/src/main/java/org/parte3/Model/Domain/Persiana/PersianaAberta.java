package org.parte3.Model.Domain.Persiana;

import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class PersianaAberta implements EstadoPersiana {
    @Override
    public void abrir(PersianaContext persianaContext) throws Exception {
        throw new EstadoInvalidoException("A persiana já está aberta");
    }

    @Override
    public void fechar(PersianaContext persianaContext) throws Exception {
        for(PersianaCasa persiana : persianaContext.getPersianas()) {
            persiana.fechar();
        }
        persianaContext.definirNovoEstado(new PersianaFechada());
    }
}

