export class Aleatorizador {
    public aleatorizar() {
        const aleatorios = this.getAleatorios()
        const menorMaior = this.getMaiorMenor(this.getAleatorios());
        return `${aleatorios}\n${menorMaior}`;
    }

    public getAleatorios() {
        const aleatorios: Array<number> = [];
        for (let i = 0; i < 10; i ++) {
            let aleatoria = Math.floor(Math.random() * 100);
            aleatorios.push(aleatoria);
        }
        return aleatorios;
    }

    public getMaiorMenor(numeros: Array<number>) {
        let menor = 100;
        let maior = 0;
        for (let i = 0; i <= numeros.length; i++) {
            if (menor > numeros[i])
                menor = numeros[i];
            if (maior < numeros[i])
                maior = numeros[i];
        }
        return `Menor: ${menor}\nMaior: ${maior}`;
    }
}