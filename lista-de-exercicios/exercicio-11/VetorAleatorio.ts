export class VetorAleatorio {
    private numeros: Array<number>;

    public constructor (numeros: Array<number>) {
        this.numeros = numeros;
    }

    public gerarNumeros(quantidade: number): Array<number> {
        this.numeros = [];
        for (let i = 0; i <= quantidade - 1; i ++) {
            let aleatorio = Math.floor(Math.random() * 1000);
            this.numeros.push(aleatorio);
        }
        return this.numeros;
    }

    public getArray() {
        return this.numeros;
    }
}