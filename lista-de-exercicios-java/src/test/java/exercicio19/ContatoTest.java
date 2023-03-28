package exercicio19;

import org.example.exercicio19.Categorias;
import org.example.exercicio19.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContatoTest {

    private Contato rafflesia;
    private Contato sera;

    @BeforeEach
    void iniciar() {
        rafflesia = new Contato("Rafflesia", 25, 999991111);
        sera = new Contato("Sera", 12, 973157318, Categorias.AMIGOS);
    }

    @DisplayName("Deve retornar a categoria do contato")
    @Test
    void retornarCategoria() {
        rafflesia.getCategoria();
        sera.getCategoria();

        assertEquals("Nenhuma", rafflesia.getCategoria());
        assertEquals("AMIGOS", sera.getCategoria());
    }

    @DisplayName("Deve retornar as informações do contato")
    @Test
    void retornarContato() {
        rafflesia.getContato();
        sera.getContato();

        assertEquals("Nome: Rafflesia\nTelefone: (25)999991111" +
                "\nCategoria: Nenhuma", rafflesia.getContato());
        assertEquals("Nome: Sera\nTelefone: (12)973157318" +
                "\nCategoria: AMIGOS", sera.getContato());
    }

    @DisplayName("Deve alterar o nome do contato")
    @Test
    void alterarNome() {
        rafflesia.setNome("pudica");

        assertEquals("pudica", rafflesia.getNome());
    }

    @DisplayName("Deve alterar o número do contato")
    @Test
    void alterarNumero() {
        rafflesia.setNumero(989879898);

        assertEquals(989879898, rafflesia.getNumero());
    }

    @DisplayName("Deve alterar o número do contato")
    @Test
    void alterarDdd() {
        rafflesia.setDdd(11);

        assertEquals(11, rafflesia.getDdd());
    }

    @DisplayName("Deve alterar a categoria do contato")
    @Test
    void alterarCategoria() {
        rafflesia.setCategoria(Categorias.TRABALHO);

        assertEquals("TRABALHO", rafflesia.getCategoria());
    }
}
