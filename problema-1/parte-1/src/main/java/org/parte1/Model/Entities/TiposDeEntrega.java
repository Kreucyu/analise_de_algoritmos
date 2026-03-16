package org.parte1.Model.Entities;

import org.parte1.Model.Services.PACService;
import org.parte1.Model.Services.RETIRADAService;
import org.parte1.Model.Services.SEDEXService;
import org.parte1.Model.Services.TipoEntrega;

public enum TiposDeEntrega {
    SEDEX {
        public TipoEntrega criar() {
            return new SEDEXService();
        }
    }, PAC {
        public TipoEntrega criar() {
            return new PACService();
        }
    }, RETIRADA {
        public TipoEntrega criar() {
            return new RETIRADAService();
        }
    };
    public abstract TipoEntrega criar();
}
