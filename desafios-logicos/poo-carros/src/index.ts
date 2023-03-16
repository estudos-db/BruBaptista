import { Carro } from './Carro/Carro.js';

const carro = new Carro ('marca', 'modelo', 2023, 'cor', 25);

carro.acelerar();
console.log(carro.mostrarVelocidade());
carro.frear();
console.log(carro.mostrarVelocidade());