export class Produto {
    private nome: string;
    private preco: number;
    private quantidade: number;

    public constructor (
        nome: string,
        preco: number,
        quantidade?: number) {
            this.nome = nome;
            this.preco = preco;
            if (preco <= 0)
                this.preco = 0;
            this.quantidade = quantidade;
            if (quantidade <=0)
                this.quantidade = 1;
            else (quantidade = undefined)
                this.quantidade = 1;
    }

    public getPreco(): number {
        let valor = this.preco * this.quantidade
        if (this.quantidade > 50)
            valor = valor - valor * 0.25;
        else if (this.quantidade >= 21)
            valor = valor - valor * 0.20;
        else if (this.quantidade >= 11)
            valor = valor - valor * 0.10;
        return valor;
    }

    public getQuantidade(): number {
        return this.quantidade;
    }

    public setQuantidade(quantidade: number) {
        this.quantidade = quantidade;
    }
}