package org.parte3.Model.Domain.Persiana;

import org.parte3.Model.Domain.ArCondicionado.ArCondicionadoCasa;

import java.util.function.Consumer;

public interface EstadoPersiana {
    void abrir(PersianaContext persianaContext);
    void fechar(PersianaContext persianaContext);
}
