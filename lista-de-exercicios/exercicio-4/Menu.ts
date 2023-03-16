import readline from 'readline-sync';

export class Menu {
    private operador: string;
    private numero1: string;
    private numero2: string;

    public questoes() {
        this.operador = readline.question(
            'Escolha um operador para calcular:\n' +
            '+: para somar\n-: para subtrair\n*: para multiplicar\n/: para dividir\n^: para potencializar\n');
        this.numero1 = readline.question('digite o primeiro numero\n');
        this.numero2 = readline.question('digite o segundo numero\n');
    }

    public getOperador(): string {
        return this.operador;
    }

    public getNumero1(): number {
        return parseInt(this.numero1);
    }

    public getNumero2(): number {
        return parseInt(this.numero2); 
    }
}