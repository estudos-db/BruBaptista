export class NovoFibonacci {
    private numero: number;

    public constructor (numero: number) {
        this.numero = numero;
    }

    public contar(): Array<number> {
        let serie: Array<number> = [];
        let f0 = 0;
        let f1 = 1;
        let f = 0;
        
        if (Number.isInteger(this.numero) && this.numero >= 0) {
            serie.push(f0)
            if (this.numero > 0) {
                serie.push(f1)
                if (this.numero > 1) {
                    while (f <= this.numero) {
                        f = f0 + f1;
                        if (f <= this.numero) {
                            serie.push(f);
                            f0 = f1;
                            f1 = f;
                        }
                    }
                } 
            } 
        } else
            throw Error ('Número inválido');
        return serie;
    }
}