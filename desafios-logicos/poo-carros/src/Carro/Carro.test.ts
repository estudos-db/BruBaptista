import { jest } from "@jest/globals";
import { Carro } from './Carro.js';

describe('Método acelerar', () => {
    test('Acelerar aumenta a velocidade do carro', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', 25);
        carro.acelerar();

        expect(carro.mostrarVelocidade()).toBe("10 km/h");
    });

    test('A velocidade atual do carro não pode ultrapassar a velocidade máxima', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', 5);
        carro.acelerar();

        expect(carro.mostrarVelocidade()).toBe("5 km/h");
    });
});

describe('Método frear', () => {
    test('Frear diminui a velocidade do carro', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', 25);
        carro.acelerar();
        carro.frear();

        expect(carro.mostrarVelocidade()).toBe("3 km/h");
    });

    test('A velocidade atual do carro não pode ser menor que 0', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', 25);
        carro.frear();

        expect(carro.mostrarVelocidade()).toBe("0 km/h");
    });

    test('Frear um carro com velocidade 0 não diminui a velocidade', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', 25);
        carro.frear();

        expect(carro.mostrarVelocidade()).toBe("0 km/h");
    })
});

describe('constructor', () => {
    test('A velocidade máxima do carro não pode ser menor que 1', () => {
        const carro = new Carro ('marca', 'modelo', 2023, 'cor', -10);

        expect(carro.getVelocidadeMaxima()).toBe("1 km/h")
    });

    test('O ano do carro não pode ser menor que 1885', () => {
        expect(() => new Carro ('marca', 'modelo', 1884, 'cor', 25)).toThrowError();
    });
});