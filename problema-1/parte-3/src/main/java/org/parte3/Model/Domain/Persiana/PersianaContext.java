package org.parte3.Model.Domain.Persiana;

import java.util.List;

public class PersianaContext {
    private List<PersianaCasa> persianas;
    private EstadoPersiana estadoAtual;

    public PersianaContext(List<PersianaCasa> persianas) {
        this.persianas = persianas;
        this.estadoAtual = new PersianaFechada();
    }

    public void abrir(){
        estadoAtual.abrir(this);
    }

    public void fechar(){
        estadoAtual.fechar(this);
    }

    public List<PersianaCasa> getPersianas() {
        return this.persianas;
    }

    public void setNovoEstado(EstadoPersiana novoEstado) {
        this.estadoAtual = novoEstado;
    }
}
