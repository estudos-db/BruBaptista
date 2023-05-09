package com.example.livraria.service;

import com.example.livraria.model.Locatario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LocatarioServiceTest {

    @InjectMocks
    LocatarioService locatarioService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve modificar o nome do locatario")
    @Test
    public void deveModificarNome() {
        Locatario locatario = new Locatario();
        locatario.setNome("Teste");
        locatarioService.setNome("NovoNome", locatario);

        assertEquals("NovoNome", locatario.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do locatario for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        Locatario locatario = new Locatario();
        locatario.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setNome("", locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setNome(null, locatario));
    }

    @DisplayName("Deve modificar o telefone do locatario")
    @Test
    public void deveModificarTelefone() {
        Locatario locatario = new Locatario();
        locatario.setTelefone("01234567890");
        locatarioService.setTelefone("09876543210", locatario);

        assertEquals("(09)876543210", locatario.getTelefone());
    }

    @DisplayName("Deve retornar erro se o telefone do locatario tiver mais ou menos de 11 dígitos")
    @Test
    public void deveRetornarErroTelefoneComMaisOuMenosDeOnzeDigitos() {
        Locatario locatario = new Locatario();
        locatario.setTelefone("01234567890");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone("1234567890", locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone("123456789012", locatario));
    }

    @DisplayName("Deve retornar erro se o telefone do locatario contiver caracteres que não são números")
    @Test
    public void deveRetornarErroTelefoneComCaracteresQueNaoSaoNumeros() {
        Locatario locatario = new Locatario();
        locatario.setTelefone("12345678");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone("a1234567890", locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone("12345(67890", locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone("12345-67890", locatario));
    }


    @DisplayName("Deve modificar o email do locatario")
    @Test
    public void deveModificarEmail() {
        Locatario locatario = new Locatario();
        locatario.setEmail("a@b.com");
        locatarioService.setNome("aaa@bbb.com.br", locatario);

        assertEquals("aaa@bbb.com.br", locatario.getNome());
    }

    @DisplayName("Deve retornar erro se o email do locatario for nulo ou conter espaços, ou não conter @")
    @Test
    public void deveRetornarErroEmailNuloOuComEspacosOuComArroba() {
        Locatario locatario = new Locatario();
        locatario.setEmail("a@b.com");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail("aaa @bbb.com.br", locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail(null, locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail("aaabbb.com.br", locatario));
    }

    @DisplayName("Deve modificar a data de nascimento do locatario")
    @Test
    public void deveModificarAno() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1991, 6, 11);

        Locatario locatario = new Locatario();
        locatario.setDataDeNascimento(data);
        locatarioService.setDataDeNascimento(data2, locatario);

        assertEquals(data2, locatario.getDataDeNascimento());
    }

    @DisplayName("Deve retornar erro se a data de nascimento do locatario for nulo, ou o ano for menor que 1900")
    @Test
    public void deveRetornarErroDataDePublicacaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1899, 6, 11);
        Locatario locatario = new Locatario();
        locatario.setDataDeNascimento(data);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setDataDeNascimento(null, locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setDataDeNascimento(data2, locatario));
    }

    @DisplayName("Deve modificar o cpf do locatario")
    @Test
    public void deveModificarCpf() {
        Locatario locatario = new Locatario();
        locatario.setCpf(123456789);
        locatarioService.setcpf(987654321, locatario);

        assertEquals(987654321, locatario.getCpf());
    }

    @DisplayName("Deve retornar erro se o cpf do locatario for nulo, zero ou menor")
    @Test
    public void deveRetornarErroCpfNuloZeroOuMenor() {
        Locatario locatario = new Locatario();
        locatario.setCpf(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(null, locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(0, locatario));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(-10, locatario));
    }
}