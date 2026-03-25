package org.parte3.Model.Domain.Persiana;

import br.furb.analise.algoritmos.PersianaNatLight;
import org.parte3.Model.Domain.Exceptions.FalhaNoDispositivoException;

public class PersianaNatLightAdapter implements PersianaCasa {
    private final PersianaNatLight persianaNatLight;

    public PersianaNatLightAdapter(PersianaNatLight persianaNatLight) {
        this.persianaNatLight = persianaNatLight;
    }

    @Override
    public void abrir() {
        try {
            if (!persianaNatLight.estaPalhetaAberta()) {
                persianaNatLight.abrirPalheta();
            }
            persianaNatLight.subirPalheta();
        } catch (Exception e) {
            throw new FalhaNoDispositivoException("A persiana não conseguiu abrir!");
        }
    }

    @Override
    public void fechar() {
        try {
            if (persianaNatLight.estaPalhetaErguida()) {
                persianaNatLight.descerPalheta();
            }
            persianaNatLight.fecharPalheta();
        } catch (Exception e) {
            throw new FalhaNoDispositivoException("A persiana não conseguiu fechar!");
        }
    }
}
