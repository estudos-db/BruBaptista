export class Pessoa {
    private idade: number;

    public constructor(idade: number) {
        this.idade = idade;
        if (idade <= 0)
            this.idade = 0;
    }

    public getIdade(): number {
        return this.idade;
    }

    public verificar(): boolean {
        return 18 <= this.idade;
    }
}