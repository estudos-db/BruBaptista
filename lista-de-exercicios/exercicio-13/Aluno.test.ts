import { jest } from '@jest/globals';
import { Aluno } from './Aluno';

describe('Classe Aluno', () => {
    test('A nota não pode ser menor que zero', () => {
        const alunoMenor = new Aluno(-10);

        expect(alunoMenor.getNotas()).toStrictEqual([0]);
    })

    test('A nota não pode ser maior que dez', () => {
        const alunoMaior = new Aluno(20);

        expect(alunoMaior.getNotas()).toStrictEqual([10]);
    })

    test('Deve adicionar uma nova nota ao grupo de notas', () => {
        const aluno = new Aluno(1);
        aluno.adicionarNota(5);

        expect(aluno.getNotas()).toStrictEqual([1, 5]);
    })

    test('Deve retornar a média das notas', () => {
        const alunoMedia = new Aluno(4);
        alunoMedia.adicionarNota(6);

        expect(alunoMedia.getMedia()).toBe(5);
    })

    test('Deve retornar o status correto do aluno', () => {
        const alunoAprovado = new Aluno(6.1);

        expect(alunoAprovado.getStatus()).toBe('Aprovado');

        const alunoSuplementar = new Aluno(6);
        const alunoSuplementar2 = new Aluno(4);

        expect(alunoSuplementar.getStatus()).toBe('Verificacao Suplementar');
        expect(alunoSuplementar2.getStatus()).toBe('Verificacao Suplementar');

        const alunoReprovado = new Aluno(3.9);

        expect(alunoReprovado.getStatus()).toBe('Reprovado');
    })

    test('Deve retornar o status correto após adicionar uma nova nota', () => {
        const aluno = new Aluno(6);

        expect(aluno.getStatus()).toBe('Verificacao Suplementar');

        aluno.adicionarNota(7);

        expect(aluno.getStatus()).toBe('Aprovado');
    })
})