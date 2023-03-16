import readline from 'readline-sync';

export class Loop {
    private resposta: number

    public loopar() {
        let contagem = 0;
        while (this.resposta != 10) {
            let outraResposta = readline.question(`Contador: ${contagem ++}\n`);
            this.resposta = parseInt(outraResposta);
        }
    }
}