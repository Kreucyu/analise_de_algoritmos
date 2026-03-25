package org.parte3.Model.Domain.Persiana;

public interface EstadoPersiana {
    void abrir(PersianaContext persianaContext) throws Exception;
    void fechar(PersianaContext persianaContext) throws Exception;
}
