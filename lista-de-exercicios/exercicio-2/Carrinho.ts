import { Produto } from "./Produto.js";

export class Carrinho {
    private listaCompras: Array<Produto>;
    private valorTotal: number;

    public constructor (listaCompras: Array<Produto>) {
        this.listaCompras = listaCompras;
        this.valorTotal = 0;
    }

    public getLista(): Array<Produto> {
        return this.listaCompras;
    }
    
    public getValorTotal(): number {
        this.valorTotal = 0;
        this.listaCompras.forEach(Produto => this.valorTotal = Produto.getPreco() + this.valorTotal);
        return this.valorTotal;
    }

    public adicionarProdutos(produto: Produto) {
        if (this.listaCompras.includes(produto))
            produto.setQuantidade(produto.getQuantidade() +1);
        else this.listaCompras.push(produto);
    }
}