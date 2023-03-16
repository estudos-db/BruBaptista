export class Matriz {
    private numeros: Array<Array<number>>;

    public constructor (numeros: Array<Array<number>>) {
        this.numeros = numeros;
    }

    public somar() {
        let soma = 0;
        for(let i = 0; i < this.numeros.length; i++) {
            soma += this.numeros[i][i];
        }
        return soma;
    }
}