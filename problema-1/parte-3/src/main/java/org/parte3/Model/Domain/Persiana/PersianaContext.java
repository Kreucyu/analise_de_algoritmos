package org.parte3.Model.Domain.Persiana;

import java.util.List;

public class PersianaContext {
    private List<PersianaCasa> persianas;
    private EstadoPersiana estadoAtual;

    public PersianaContext(List<PersianaCasa> persianas) {
        this.persianas = persianas;
        this.estadoAtual = new PersianaFechada();
    }

    public void abrir() throws Exception {
        estadoAtual.abrir(this);
    }

    public void fechar() throws Exception {
        estadoAtual.fechar(this);
    }

    public void definirNovoEstado(EstadoPersiana novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public List<PersianaCasa> getPersianas() {
        return this.persianas;
    }
}
