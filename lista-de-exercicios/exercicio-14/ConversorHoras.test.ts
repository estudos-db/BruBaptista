import { jest } from '@jest/globals';
import { ConversorHoras } from './ConversorHoras';

const conversorHoras = new ConversorHoras(7023);

describe('Classe ConversorHoras', () => {
    test('Deve receber os segundos que sobraram', () => {
        expect(conversorHoras.receberSegundos()).toBe(3);
    })

    test('Deve receber os minutos totais', () => {
        expect(conversorHoras.converterMinutos()).toBe(117);
    })

    test('Deve receber os minutos que sobraram', () => {
        expect(conversorHoras.receberMinutos()).toBe(57);
    })

    test('Deve receber as horas', () => {
        expect(conversorHoras.converterHoras()).toBe(1);
    })

    test('Deve receber o tempo em horas, minutos e segundos', () => {
        expect(conversorHoras.getHoras()).toBe('1h57min3seg');
    })
})