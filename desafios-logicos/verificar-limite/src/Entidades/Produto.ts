export class Produto {
    private nome: string;
    private valor: number;

    public constructor (
        nome: string,
        valor: number) {
            this.nome = nome;
            this.valor = valor;
            if (valor <= 0)
                this.valor = 0;
    }

    public getNome(): string {
        return this.nome;
    }

    public setNome(produto: string) {
        this.nome = produto;
    }

    public getValor(): number {
        return this.valor;
    }

    public setValor(valor: number) {
        this.valor = valor;
    }
}