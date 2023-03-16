export class Tabuada {
    private numero: number;

    public constructor (numero: number) {
        this.numero = numero;
    }

    // Calcular que retorna um array com os resultados
    public calcular() {
        const resultados: Array<number> = [];

        if (!this.numero)
            throw Error ('Número inválido');
        for (let i = 1; i <= 10; i ++) {
            let resultado: number = this.numero * i;
            resultados.push(resultado);
        }
        return resultados;
    }

    // Calcular que retorna um array com as fórmulas e resultados
    public calcularSt() {
        const resultados: Array<string> = [];

        if (!this.numero)
            throw Error ('Número inválido');
        for (let i = 1; i <= 10; i ++) {
            let resultado: string = `${this.numero}x${i}=` + this.numero * i;
            resultados.push(resultado);
        }
        return resultados;
    }
}