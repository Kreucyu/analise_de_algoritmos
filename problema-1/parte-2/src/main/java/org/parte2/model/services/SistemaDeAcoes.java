package org.parte2.model.services;

import org.parte2.model.entities.Acao;
import org.parte2.model.entities.Match;
import org.parte2.model.entities.Ordem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SistemaDeAcoes{
    private List<Acao> listaDeAcoes;

    public SistemaDeAcoes() {
        this.listaDeAcoes = new ArrayList<>();
    }

    public List<Acao> getListaDeAcao() {
        return this.listaDeAcoes;
    }

    public void adicionarAcao(Acao acao) {
        this.listaDeAcoes.add(acao);
    }

    public Optional<BigDecimal> adicionarOrdemEProcessar(Acao acao, Ordem ordem) {
        acao.adicionarOrdem(ordem);

        Optional<BigDecimal> resultado = processarTransacao(acao);

        resultado.ifPresent(acao::atualizarValor);

        return resultado;
    }

    public Optional<Match> buscarMatch(Acao acao) {

        for (Ordem ordemCompra : acao.getOrdensDeCompra()) {

            List<Ordem> vendasPossiveis =
                    acao.getOrdensDeVenda().get(ordemCompra.getValorOrdem());

            if (vendasPossiveis == null) continue;

            for (Ordem venda : vendasPossiveis) {

                Match match = new Match(ordemCompra, venda);

                if (!match.envolveMesmoInvestidor()) {
                    return Optional.of(match);
                }
            }
        }

        return Optional.empty();
    }

    public BigDecimal executarMatch(Acao acao, Match match) {

        Ordem compra = match.getCompra();
        Ordem venda = match.getVenda();

        acao.removerOrdem(compra);
        acao.removerOrdem(venda);

        return compra.getValorOrdem();
    }

    public Optional<BigDecimal> processarTransacao(Acao acao) {

        Optional<Match> match = buscarMatch(acao);

        if (match.isPresent()) {
            BigDecimal novoValor = executarMatch(acao, match.get());
            return Optional.of(novoValor);
        }

        return Optional.empty();
    }
}
