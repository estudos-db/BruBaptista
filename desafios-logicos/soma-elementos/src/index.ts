import { Comparador } from './SomaLista/Comparador.js';

const somaLista = new Comparador([1,2,3]);
const combinacaoFalsa = somaLista.comparar(0);
const combinacaoFalsa2 = somaLista.comparar(1);
const combinacaoFalsa3 = somaLista.comparar(7);
const combinacaoVerdade = somaLista.comparar(3);
const combinacaoVerdade2 = somaLista.comparar(6);

console.log(combinacaoFalsa);
console.log(combinacaoFalsa2);
console.log(combinacaoFalsa3);
console.log(combinacaoVerdade);
console.log(combinacaoVerdade2);