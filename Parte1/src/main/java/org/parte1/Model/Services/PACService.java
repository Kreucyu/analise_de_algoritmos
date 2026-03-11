package org.parte1.Model.Services;

public class PACService implements TipoEntrega {
    @Override
    public Double calcularValorDoEnvio(Double PesoPedido) {
        double valorEnvio = 0.0;

        double umQuilo = 1.0;
        if (PesoPedido <= umQuilo) {
            valorEnvio = 10.0;
            return valorEnvio;
        }
        double doisQuilos = 2.0;
        if (PesoPedido >= umQuilo && PesoPedido <= doisQuilos) {
            valorEnvio = 15.0;
            return valorEnvio;
        }
        System.out.println("\nNão é possível fazer entregas acima de 2Kg!");
        return valorEnvio;
    }
}
