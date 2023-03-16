export class SuperSet {
    private combinacoes: Array<number> = [];

    public constructor(combinacoes: Set<number>) {
        combinacoes.forEach(elemento => this.combinacoes.push(elemento));
    }

    public combinar(): Set<Set<number>> {
        const vetorCombinacoes : Set<Set<number>> = new Set<Set<number>>();
        vetorCombinacoes.add(new Set<number>);
         if (this.combinacoes.length > 1)
             this.adicionarValoresIndividuais(vetorCombinacoes);
        this.adicionarCombinacoes(vetorCombinacoes);
        if (this.combinacoes.length > 0)
            vetorCombinacoes.add(new Set<number>(this.combinacoes));
        return vetorCombinacoes;
    }

    private adicionarValoresIndividuais(vetorCombinacoes: Set<Set<number>>) {
            this.combinacoes.forEach(valor => {
            vetorCombinacoes.add(new Set<number>([valor]));
        });
    }

    private adicionarCombinacoes(vetorCombinacoes: Set<Set<number>>) {
        if (this.combinacoes.length > 2)
            this.gerarCombinacoes(new Set<number>(), 0, vetorCombinacoes);
    }

    private gerarCombinacoes(posicoesIgnorar: Set<number>, posicaoInicial: number, vetorCombinacoes: Set<Set<number>>) {
        for (let posicaoAtual = posicaoInicial; posicaoAtual < this.combinacoes.length; posicaoAtual++) {
            // atualizar quais posições deverão ser ignoradas na próxima chamada
            const novasPosicoesIgnorar : Set<number> = new Set<number>();
            posicoesIgnorar.forEach(posicao => novasPosicoesIgnorar.add(posicao));
            novasPosicoesIgnorar.add(posicaoAtual);
            
            // montando a combinação atual
            let combinacaoAtual : Set<number> = new Set<number>();
            for (let index = 0; index < this.combinacoes.length; index++) {
                if (!novasPosicoesIgnorar.has(index))
                    combinacaoAtual = combinacaoAtual.add(this.combinacoes[index]);
            }
            if (combinacaoAtual.size > 0) vetorCombinacoes.add(combinacaoAtual);
            if (novasPosicoesIgnorar.size < this.combinacoes.length - 2)
                this.gerarCombinacoes(novasPosicoesIgnorar, posicaoAtual + 1, vetorCombinacoes);
        }
    }
}