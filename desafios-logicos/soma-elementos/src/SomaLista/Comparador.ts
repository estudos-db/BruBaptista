import { Combinador } from './Combinador.js'

export class Comparador {
    private comparacoes: Array<Array<number>> = [];

    public constructor(vetorCombinacoes: Array<number>) {
        const combinador = new Combinador(vetorCombinacoes);
        this.comparacoes = combinador.combinar();
    }

    public comparar(k: number) : boolean {
        let encontrado = false;
        this.comparacoes.forEach(combinacao => {
            let resultado = this.somarCombinacao(combinacao);
            if (k == resultado)
                encontrado = true;
        });
        return encontrado;
    }

    private somarCombinacao(combinacao: Array<number>) : number {
        let resultado : number = null;
        combinacao.forEach(valor => {
            if (!resultado)
                resultado = valor;
            else
                resultado += valor;
        });
        return resultado;
    }
}