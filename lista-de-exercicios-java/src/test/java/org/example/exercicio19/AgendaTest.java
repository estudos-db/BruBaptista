package org.example.exercicio19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    Agenda agenda = new Agenda();
    Endereco endereco = new Endereco
            (02012021,
                    "Av. Olavo Fontoura",
                    1209,
                    "Santana",
                    "São Paulo",
                    "SP");
    Contato rafflesia = new Contato("Rafflesia",
            25,
            999991111,
            "rafflesia@trap.com",
            endereco);
    @DisplayName("Deve adicionar um novo contato")
    @Test
    void adicionaContato() {
        agenda.adicionarContato(rafflesia);

        assertTrue(agenda.getContatos().contains(rafflesia));
    }

    @DisplayName("Deve retornar erro ao tentar adicionar um contato já presente na agenda")
    @Test
    void deveRetornarErroAdicionarContatoIgual() {
        agenda.adicionarContato(rafflesia);

        assertThrows(IllegalArgumentException.class, () -> agenda.adicionarContato(rafflesia));
    }

    @DisplayName("Deve remover um contato presente na agenda")
    @Test
    void removeContato() {
        agenda.adicionarContato(rafflesia);
        agenda.removerContato(rafflesia);

        assertFalse(agenda.getContatos().contains(rafflesia));
    }

    @DisplayName("Deve retornar erro ao tentar remover um contato não presente na agenda")
    @Test
    void deveRetornarErroRemoverContatoNaoPresenteNaAgenda() {
        assertThrows(IllegalArgumentException.class, () -> agenda.removerContato(rafflesia));
    }

    @DisplayName("Deve buscar um contato na agenda")
    @Test
    void buscaContato() {
        agenda.adicionarContato(rafflesia);

        assertEquals("Nome: Rafflesia\n" +
                "Telefone: (25)999991111\n" +
                "E-mail: rafflesia@trap.com\n" +
                "CEP: 529425\n" +
                "Av. Olavo Fontoura, 1209, \n" +
                "Santana\n" +
                "São Paulo, SP", agenda.buscarContatoPorNome("Rafflesia"));
    }

    @DisplayName("Deve retornar erro ao tentar buscar um contato não presente na agenda")
    @Test
    void deveRetornarErroBuscarContatoNaoPresenteNaAgenda() {
        Contato sera = new Contato("Sera",
                22,
                888881111,
                "sera@trap.com",
                endereco);
        agenda.adicionarContato(sera);

        assertThrows(IllegalArgumentException.class, () -> agenda.buscarContatoPorNome("Rafflesia"));
    }

    @DisplayName("Deve listar todos contatos na agenda")
    @Test
    void listaContatos() {
        agenda.adicionarContato(rafflesia);

        assertEquals("Nome: Rafflesia\n" +
                "Telefone: (25)999991111\n" +
                "E-mail: rafflesia@trap.com\n" +
                "CEP: 529425\n" +
                "Av. Olavo Fontoura, 1209, \n" +
                "Santana\n" +
                "São Paulo, SP\n", agenda.listarTodosContatos());
    }

    @DisplayName("Deve retornar essa mensagem ao tentar listar todos contatos na agenda vazia")
    @Test
    void deveRetornarMensagemListarContatosNaAgendaVazia() {
        assertEquals("A agenda está vazia", agenda.listarTodosContatos());
    }
}