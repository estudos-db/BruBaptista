 export class Carro {
    private marca: string;
    private modelo: string;
    private ano: number;
    private cor: string;
    private velocidadeMaxima: number;
    private velocidadeAtual: number;

    public constructor (
        marca: string,
        modelo: string,
        ano: number,
        cor: string,
        velocidadeMaxima: number) {
            this.marca = marca;
            this.modelo = modelo;
            this.setAno(ano);
            this.cor = cor;
            this.setVelocidadeMaxima(velocidadeMaxima);
            this.velocidadeAtual = 0;
    }

    public setAno(ano: number) {
        this.ano = ano;
        if (ano <= 1885)
            throw Error('O ano do carro não pode ser menor que 1885.');
    }

    public getVelocidadeMaxima(): string {
        return this.velocidadeMaxima + " km/h";
    }

    public setVelocidadeMaxima(velocidadeMaxima: number) {
        this.velocidadeMaxima = velocidadeMaxima;
            if (velocidadeMaxima <= 1)
            this.velocidadeMaxima = 1;
    }

    public mostrarVelocidade(): string {
        return this.velocidadeAtual + " km/h";
    }

    public acelerar() {
        this.velocidadeAtual += 10;
        this.validar();
    }

    public frear() {
        this.velocidadeAtual -= 7;
        this.validar();
    }

    private validar() {
        if (this.velocidadeAtual > this.velocidadeMaxima)
            this.velocidadeAtual = this.velocidadeMaxima;
        else if (this.velocidadeAtual <= 0)
            this.velocidadeAtual = 0;
    }
}