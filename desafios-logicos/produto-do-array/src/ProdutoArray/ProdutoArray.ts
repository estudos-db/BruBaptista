export class ProdutoArray {
    private elementos: Array<number> = [];

    public constructor(arrayInicial: Array<number>) {
        this.elementos = arrayInicial;
    }

    public multiplicador(): Array<number> {
        const produto: Array<number> = [];

        for (let indexProduto = 0; indexProduto < this.elementos.length; indexProduto ++) {
            let resultado = this.multiplicarElementos(indexProduto);
            if (resultado != null)
                produto.push(resultado);
        }
        return produto;
    }

    private multiplicarElementos(indexProduto: number): number {
        let resultado : number = null;
    
        for (let indexMultiplicador = 0; indexMultiplicador < this.elementos.length; indexMultiplicador ++) {
            if (indexProduto == indexMultiplicador) continue;
            if (resultado == null)
                resultado = this.elementos[indexMultiplicador];
            else
                resultado *= this.elementos[indexMultiplicador];
        }
        return resultado;
    }
}