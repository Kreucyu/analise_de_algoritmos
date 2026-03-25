package org.parte3.Model.Domain.Persiana;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.parte3.Model.Domain.Exceptions.EstadoInvalidoException;

public class PersianaAberta implements EstadoPersiana {
    @Override
    public void abrir(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception {
        throw new EstadoInvalidoException("A persiana já está aberta!");
    }

    @Override
    public void fechar(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception {
        persianaSolarius.descerPersiana();
    }
}
