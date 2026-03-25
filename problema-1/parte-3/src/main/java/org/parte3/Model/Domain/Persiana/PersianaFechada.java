package org.parte3.Model.Domain.Persiana;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class PersianaFechada implements EstadoPersiana {

    @Override
    public void abrir(PersianaContext persianaContext) throws Exception {
        for(PersianaCasa persiana : persianaContext.listarPersianas()) {
            persiana.abrir();
        }
    }

    @Override
    public void fechar(PersianaContext persianaContext) throws Exception {
        throw new EstadoInvalidoException("A persiana já está fechada!");
    }
}
