export enum Escolhas {PEDRA, PAPEL, TESOURA};

export interface JogadorBase {
    getEscolha(): Escolhas;
}

export class Jokenpo {
    private jogador1: JogadorBase;
    private jogador2: JogadorBase;

    public constructor (jogador1: JogadorBase, jogador2: JogadorBase) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public jogar(): JogadorBase | string {
        const jogador1 = this.jogador1.getEscolha();
        const jogador2 = this.jogador2.getEscolha();
        const pedra = Escolhas.PEDRA;
        const papel = Escolhas.PAPEL;
        const tesoura = Escolhas.TESOURA;
        
        if (jogador1 == jogador2)
            return 'Empate';
        else if (jogador1 == papel && jogador2 == pedra)
            return `Vencedor: Player 1 com ${Escolhas[jogador1]}`;
        else if (jogador1 == tesoura && jogador2 == papel)
            return `Vencedor: Player 1 com ${Escolhas[jogador1]}`;
        else if (jogador1 == pedra && jogador2 == tesoura)
            return `Vencedor: Player 1 com ${Escolhas[jogador1]}`;
        return `Vencedor: Player 2 com ${Escolhas[jogador2]}`;
    }
}