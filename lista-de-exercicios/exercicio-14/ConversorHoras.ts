export class ConversorHoras {
    private tempo: number;

    public constructor (tempo: number) {
        this.tempo = tempo;
    }

    public getHoras(): string {
        return `${this.converterHoras()}h${this.receberMinutos()}min${this.receberSegundos()}seg`;
    }

    public receberSegundos() {
        const segundos = this.tempo % 60;
        return segundos;
    }

    public converterMinutos() {
        const minutos = Math.floor(this.tempo / 60);
        return minutos;
    }

    public receberMinutos() {
        const minutosSobra = this.converterMinutos() % 60;
        return minutosSobra;
    }

    public converterHoras() {
        const horas = Math.floor(this.converterMinutos() / 60);
        return horas;
    }
}