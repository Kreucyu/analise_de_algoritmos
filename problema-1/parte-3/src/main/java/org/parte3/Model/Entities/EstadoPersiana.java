package org.parte3.Model.Entities;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;

public interface EstadoPersiana {
    void abrir(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception;
    void fechar(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception;
}
