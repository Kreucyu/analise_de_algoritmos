package org.parte1.Model.Services;

public class SEDEXService implements TipoEntrega {

    @Override
    public static Double calcularValorDoEnvio(Double PesoPedido) {
        double quinhentosGramas = 0.5;
        double valorEnvio = 0.0;
        if(PesoPedido <= quinhentosGramas){
            valorEnvio = 12.50;
            return valorEnvio;
        }

        double umQuilo = 1.0;
        if(PesoPedido >= quinhentosGramas && PesoPedido <= umQuilo){
            valorEnvio = 20.0;
            return valorEnvio;
        }
        double adicional = 0.1;
        valorEnvio = 46.50;
        if(PesoPedido > umQuilo + adicional){
            double valorAdicional = Math.round((PesoPedido - umQuilo) / adicional) * 1.5;
            valorEnvio += valorAdicional;
            return valorEnvio;
        }
        return valorEnvio;
    }
}
