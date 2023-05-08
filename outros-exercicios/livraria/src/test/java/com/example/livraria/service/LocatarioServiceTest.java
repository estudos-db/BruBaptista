package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
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
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setNome("Teste");
        locatarioService.setNome("NovoNome", locatarioDto);

        assertEquals("NovoNome", locatarioDto.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do locatario for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setNome("", locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setNome(null, locatarioDto));
    }

    @DisplayName("Deve modificar o telefone do locatario")
    @Test
    public void deveModificarTelefone() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setTelefone(10, 12345678);
        locatarioService.setTelefone(99, 123456789, locatarioDto);

        assertEquals("(99)123456789", locatarioDto.getTelefone());
    }

    @DisplayName("Deve retornar erro se o ddd do locatario tiver mais ou menos de 2 dígitos")
    @Test
    public void deveRetornarErroDddComMaisOuMenosDeDoisDigitos() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setTelefone(10, 12345678);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone(1, 123456789, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone(111, 123456789, locatarioDto));
    }

    @DisplayName("Deve retornar erro se o número do locatario tiver menos de 8, ou mais de 9 dígitos")
    @Test
    public void deveRetornarErroNumeroComMenosDeOitoOuMaisDeNoveDigitos() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setTelefone(10, 12345678);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone(10, 1234567, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setTelefone(10, 1234567890, locatarioDto));
    }

    @DisplayName("Deve modificar o email do locatario")
    @Test
    public void deveModificarEmail() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setEmail("a@b.com");
        locatarioService.setNome("aaa@bbb.com.br", locatarioDto);

        assertEquals("aaa@bbb.com.br", locatarioDto.getNome());
    }

    @DisplayName("Deve retornar erro se o email do locatario for nulo ou conter espaços, ou não conter @")
    @Test
    public void deveRetornarErroEmailNuloOuComEspacosOuComArroba() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setEmail("a@b.com");

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail("aaa @bbb.com.br", locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail(null, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setEmail("aaabbb.com.br", locatarioDto));
    }

    @DisplayName("Deve modificar a data de nascimento do locatario")
    @Test
    public void deveModificarAno() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1991, 6, 11);

        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setDataDeNascimento(data);
        locatarioService.setDataDeNascimento(data2, locatarioDto);

        assertEquals(data2, locatarioDto.getDataDeNascimento());
    }

    @DisplayName("Deve retornar erro se a data de nascimento do locatario for nulo, ou o ano for menor que 1900")
    @Test
    public void deveRetornarErroDataDePublicacaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1899, 6, 11);
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setDataDeNascimento(data);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setDataDeNascimento(null, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setDataDeNascimento(data2, locatarioDto));
    }

    @DisplayName("Deve modificar o cpf do locatario")
    @Test
    public void deveModificarCpf() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setCpf(123456789);
        locatarioService.setcpf(987654321, locatarioDto);

        assertEquals(987654321, locatarioDto.getCpf());
    }

    @DisplayName("Deve retornar erro se o cpf do locatario for nulo, zero ou menor")
    @Test
    public void deveRetornarErroCpfNuloZeroOuMenor() {
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setCpf(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(null, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(0, locatarioDto));

        assertThrows(IllegalArgumentException.class, () ->
                locatarioService.setcpf(-10, locatarioDto));
    }
}