export class Usuario {
    private limite: number;

    public constructor (limite: number) {
        this.limite = limite;
        if (limite <= 0)
            this.limite = 0;
    }

    public getLimite(): number {
        return this.limite;
    }

    public setLimite(limite: number) {
        this.limite = limite;
    }

    public identificar(valorTotal: number): boolean {
        return valorTotal <= this.limite;
    }
}