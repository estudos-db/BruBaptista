import { Escolhas } from './Jokenpo.js';
import { JogadorBase } from './Jokenpo.js';


export class Jogador implements JogadorBase {
    private escolha: Escolhas;

    public constructor (escolha: Escolhas) {
        this.escolha = escolha;
    }

    public getEscolha(): Escolhas {
        return this.escolha;
    }

    public setEscolha(escolha: Escolhas) {
        this.escolha = escolha;
    }
}