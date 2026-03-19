package org.parte2.model.entities;

public class Match {
        private final Ordem compra;
        private final Ordem venda;

        public Match(Ordem compra, Ordem venda) {
            this.compra = compra;
            this.venda = venda;
        }

        public Ordem getCompra() {
            return compra;
        }

        public Ordem getVenda() {
            return venda;
        }

        public boolean envolveMesmoInvestidor() {
            return compra.getNomeInvestidor()
                    .equals(venda.getNomeInvestidor());
        }

        @Override
        public String toString() {
            return "Match{" +
                    "compra=" + compra +
                    ", venda=" + venda +
                    '}';
        }

}
