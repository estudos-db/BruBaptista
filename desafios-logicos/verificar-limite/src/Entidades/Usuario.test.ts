import { jest } from "@jest/globals";
import { Usuario } from './Usuario';

describe('Usuário', () => {
    test('O valor do limite não pode ser negativo', () => {
        const usuarioNegativo = new Usuario (-10);

        expect(usuarioNegativo.getLimite()).toBe(0);
    })

    test('Deve retornar true se o valor total for menor ou igual ao limite', () => {
        const usuario = new Usuario (10);
        usuario.identificar(5);
        usuario.identificar(10);
        usuario.identificar(15);

        expect(usuario.identificar(5)).toBeTruthy;
        expect(usuario.identificar(10)).toBeTruthy;
        expect(usuario.identificar(15)).toBeFalsy;
    })
})