package org.example.exercicio18;

public class TesteAutomoveis {
    public static void main(String[] args) {
        Automovel automovel = new Automovel(10, 20);
        automovel.desligar();
        automovel.ligar();
        automovel.desligar();

        System.out.println();
        Carro carro = new Carro(10);
        carro.desligar();
        carro.ligar();
        carro.desligar();

        System.out.println();
        Moto moto = new Moto(20);
        moto.desligar();
        moto.ligar();
        moto.desligar();

        System.out.println();
        CarroAutomatico carroA = new CarroAutomatico(25);
        carroA.desligar();
        carroA.ligar();
        carroA.pressionarFreio();
        carroA.ligar();
        carroA.desligar();

        System.out.println();
        MotoPartidaPedal motoP = new MotoPartidaPedal(35);
        motoP.desligar();
        motoP.ligar();
        motoP.puxarAcelerador();
        motoP.ligar();
        motoP.desligar();

        System.out.println();
        Guincho guincho = new Guincho(5);
        guincho.desligar();
        guincho.ligar();
        guincho.desligar();
        guincho.carregar(carroA);
        guincho.soltar();
        guincho.carregar(motoP);
        guincho.soltar();
    }
}
