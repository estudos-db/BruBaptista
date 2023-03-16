import { Escolhas } from './Jokenpo.js';
import { JogadorBase } from './Jokenpo.js';

export class Maquina implements JogadorBase {
    private escolha: Escolhas;

    public getEscolha(): Escolhas {
        const aleatoria = Math.floor(Math.random() * 3);
        this.escolha = aleatoria;
        return aleatoria;
    }
}