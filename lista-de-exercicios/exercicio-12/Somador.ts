export class Somador {
    private array: Array<Array<number>>;
    private soma: Array<number>

    public constructor (array: Array<Array<number>>) {
        this.array = array;
    }

    public somar(): Array<number> {
        let somaArray = [];
        for (let i = 0; i < this.array.length; i ++) {
            somaArray = somaArray.concat(this.array[i]);
        }
        this.soma = somaArray;
        return this.soma;
    }

    public getArray() {
        return this.soma;
    }
}