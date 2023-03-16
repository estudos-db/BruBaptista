import { jest } from '@jest/globals';
import { Tabuada } from './Tabuada';

describe('Classe Tabuada', () => {
    test('Deve retornar a tabuada do número', () => {
        const tabuadaDe2 = new Tabuada(2);

        expect(tabuadaDe2.calcular()).toStrictEqual([
            2, 4, 6, 8, 10, 12, 14, 16, 18, 20]);

        expect(tabuadaDe2.calcularSt()).toStrictEqual([
            '2x1=2', '2x2=4', '2x3=6', '2x4=8', '2x5=10',
            '2x6=12', '2x7=14', '2x8=16', '2x9=18', '2x10=20']);
    })

    test('Deve retornar um erro se não entrar um número', () => {
        const tabuadaNaN = new Tabuada(NaN);

        expect(() => tabuadaNaN.calcular()).toThrowError();
        expect(() => tabuadaNaN.calcularSt()).toThrowError();
    })
})