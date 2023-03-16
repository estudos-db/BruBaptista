export class Combinador {
    private combinacoes: Array<number> = [];

    public constructor(combinacoes: Array<number>) {
        this.combinacoes = combinacoes;
    }

    public combinar(): Array<Array<number>> {
        const vetorCombinacoes : Array<Array<number>> = [];
        this.adicionarCombinacoes(vetorCombinacoes);
        if (this.combinacoes.length > 1)
            vetorCombinacoes.push(this.combinacoes);
        return vetorCombinacoes;
    }

    private adicionarCombinacoes(vetorCombinacoes: Array<Array<number>>) {
        if (this.combinacoes.length > 2)
            this.gerarCombinacoes([], 0, vetorCombinacoes);
    }

    private gerarCombinacoes(posicoesIgnorar: Array<number>, posicaoInicial: number, vetorCombinacoes: Array<Array<number>>) {
        for (let posicaoAtual = posicaoInicial; posicaoAtual < this.combinacoes.length; posicaoAtual++) {
            // atualizar quais posições deverão ser ignoradas na próxima chamada
            const novasPosicoesIgnorar : Array<number> = [];
            posicoesIgnorar.forEach(posicao => novasPosicoesIgnorar.push(posicao));
            novasPosicoesIgnorar.push(posicaoAtual);
            
            // montando a combinação atual
            const combinacaoAtual : Array<number> = [];
            for (let index = 0; index < this.combinacoes.length; index++) {
                if (!novasPosicoesIgnorar.includes(index))
                    combinacaoAtual.push(this.combinacoes[index]);
            }

            if (combinacaoAtual.length > 0) vetorCombinacoes.push(combinacaoAtual);
            if (novasPosicoesIgnorar.length < this.combinacoes.length - 2)
                this.gerarCombinacoes(novasPosicoesIgnorar, posicaoAtual + 1, vetorCombinacoes);
        }
    }
}