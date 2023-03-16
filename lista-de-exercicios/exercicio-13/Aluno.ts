export class Aluno {
    private nota: number;
    private notas: Array<number>;
    private media: number;
    private status: string;

    public constructor (nota: number) {
        this.notas = [this.setNota(nota)];
        this.getMedia();
        this.getStatus();
    }

    public setNota(nota: number): number {
        this.nota = nota;
        if (nota <= 0)
            nota = 0;
        else if (nota >= 10)
            nota = 10;
        return nota;
    }

    public adicionarNota(nota: number) {
        this.notas.push(nota);
    }

    public getNotas() {
        return this.notas;
    }

    public getMedia() {
        let soma = 0;
        for (let i = 0; i < this.notas.length; i ++) {
            soma += this.notas[i];
        }
        this.media = soma / this.notas.length;
        return this.media;
    }

    public getStatus() {
        this.getMedia();
        if (this.media > 6)
            this.status = 'Aprovado';
        else if (this.media >= 4)
            this.status = 'Verificacao Suplementar';
        else this.status = 'Reprovado';
        return this.status;
    }
}