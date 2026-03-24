package org.parte3.Model.Services;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.parte3.Model.Exceptions.PersianaFechadaException;

public class PersianaFechada implements EstadoPersiana {

    @Override
    public void abrir(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception {
        persianaSolarius.subirPersiana();
        if(!persianaNatLight.estaPalhetaAberta()) {
            persianaNatLight.abrirPalheta();
        }
        persianaNatLight.subirPalheta();
    }

    @Override
    public void fechar(PersianaNatLight persianaNatLight, PersianaSolarius persianaSolarius) throws Exception {
        throw new PersianaFechadaException("A persiana já está fechada!");
    }
}
