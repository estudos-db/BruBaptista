import { Usuario } from './Usuario.js';
import { Produto } from './Produto.js';

export class Carrinho {
    private usuario: Usuario;
    private listaCompras: Array<Produto>;
    private valorTotal: number;

    public constructor (
        usuario: Usuario,
        listaCompras: Array<Produto>) {
            this.usuario = usuario;
            this.listaCompras = listaCompras;
            this.valorTotal = 0;
        }

    public getUsuario(): Usuario {
        return this.usuario;
    }

    public setUsuario(usuario: Usuario) {
        this.usuario = usuario;
    }

    public getLista(): Array<Produto> {
        return this.listaCompras;
    }

    public getValorTotal(): number {
        this.valorTotal = 0;
        this.listaCompras.forEach(Produto => this.valorTotal = Produto.getValor() + this.valorTotal);
        return this.valorTotal;
    }

    public adicionarProdutos(produto: Produto) {
        this.listaCompras.push(produto);
    }

    public verificarLimite():boolean {
        return this.usuario.identificar(this.valorTotal);
    }
}