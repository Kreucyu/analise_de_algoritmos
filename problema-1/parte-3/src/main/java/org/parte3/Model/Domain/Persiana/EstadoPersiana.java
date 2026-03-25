package org.parte3.Model.Domain.Persiana;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;

public interface EstadoPersiana {
    void abrir(PersianaContext persianaContext) throws Exception;
    void fechar(PersianaContext persianaContext) throws Exception;
}
