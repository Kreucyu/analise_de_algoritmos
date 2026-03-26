package org.parte3.Model.Domain.Persiana;

import br.furb.analise.algoritmos.PersianaSolarius;

public class PersianaSolariusAdapter implements PersianaCasa {
    private final PersianaSolarius persianaSolarius;

    public PersianaSolariusAdapter(PersianaSolarius persianaSolarius) {
        this.persianaSolarius = persianaSolarius;
    }
    @Override
    public void abrir() {
        persianaSolarius.subirPersiana();
    }

    @Override
    public void fechar() {
        persianaSolarius.descerPersiana();
    }
}
