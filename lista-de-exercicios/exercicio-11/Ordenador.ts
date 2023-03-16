import { VetorAleatorio } from "./VetorAleatorio.js";

export class Ordenador {
    private array: Array<number>;

    public constructor (array: Array<number>) {
        this.array = array;
    }

    public ordenar(): Array<number> {
        const array = this.array
        for (let i = 0; i < array.length; i ++) {
            for (let j = 0; j < array.length; j ++) {
                if (array[j] > array[j + 1]) {
                    [array[j], array[j + 1]] = [array[j + 1], array[j]];
                }
            }
        }
        return array;
    }
}