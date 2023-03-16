export class Fibonacci {
    private numero: number;

    public constructor (numero: number) {
        this.numero = numero;
    }

    public serializar(): Array<number> {
        let serie: Array<number> = [];
        let f0 = 0;
        let f1 = 1;
        
        if (Number.isInteger(this.numero) && this.numero >= 0) {
            serie.push(f0)
            if (this.numero > 0) {
                serie.push(f1)
                for (let i = 2; i <= this.numero; i ++) {
                    let f = f0 + f1;
                    serie.push(f);
                    f0 = f1;
                    f1 = f;
                }
            } 
        } else
            throw Error ('Número inválido');
        return serie;
    }
}