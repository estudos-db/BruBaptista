import { jest } from '@jest/globals'
import { Comparador } from './Comparador'

const combinacoes = [3,4,5];
const comparador = new Comparador(combinacoes);

describe('Classe Comparador', () => {
    test('Deve retornar verdadeiro se alguma combinação for igual ao parâmetro', () => {
        const soma1 : number = 7;
        const soma2 : number = 8;
        const soma3 : number = 9;
        const soma4 : number = 12;

        expect(comparador.comparar(soma1)).toBeTruthy();
        expect(comparador.comparar(soma2)).toBeTruthy();
        expect(comparador.comparar(soma3)).toBeTruthy();
        expect(comparador.comparar(soma4)).toBeTruthy();
    });

    test('Deve retornar falso se nenhuma combinação for igual ao parâmetro', () => {
        const somaErrada : number = 6;

        expect(comparador.comparar(somaErrada)).toBeFalsy();
    });

    test('Deve retornar falso se apenas algum número individual for igual ao parâmetro', () => {
        const numeroIndividual : number = 5

        expect(comparador.comparar(numeroIndividual)).toBeFalsy();
    });

    test('Deve retornar verdadeiro se alguma combinação e algum número individual for igual ao parâmetro', () => {
        const combinacoesDois = [3,4,7];
        const comparador = new Comparador(combinacoesDois);
        const somaCerta = 7;

        expect(comparador.comparar(somaCerta)).toBeTruthy();
    });
});