package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Livro headsFirstJava;
    Livro hobbit;
    Biblioteca aMinhaBiblioteca;

    @BeforeEach
    void setUp() {
        this.headsFirstJava = new Livro("Heads First Java", "Kathy Sierra", 2015, 760);
        this.hobbit = new Livro("Hobbit", "Tolkien", 2000, 600);

        this.aMinhaBiblioteca = new Biblioteca();
    }

    @Test
    public void testAdicionarLivro() {
        assertEquals(0, this.aMinhaBiblioteca.contarLivros());

        this.aMinhaBiblioteca.adicionarLivro(headsFirstJava);

        assertEquals(1, this.aMinhaBiblioteca.contarLivros());

        this.aMinhaBiblioteca.adicionarLivro(hobbit);

        assertEquals(2, this.aMinhaBiblioteca.contarLivros());

        assertEquals("Título: Heads First Java, Autor: Kathy Sierra, Ano: 2015, Páginas: 760, Estado: disponível\nTítulo: Hobbit, Autor: Tolkien, Ano: 2000, Páginas: 600, Estado: disponível", this.aMinhaBiblioteca.listarLivros());
        assertEquals(this.headsFirstJava.obterResumo() + "\n" + this.hobbit.obterResumo(), this.aMinhaBiblioteca.listarLivros());

    }

    @Test
    public void testRemoverLivroPorTitulo() {
        this.aMinhaBiblioteca.adicionarLivro(headsFirstJava);
        this.aMinhaBiblioteca.adicionarLivro(hobbit);

        this.aMinhaBiblioteca.removerLivroPorTitulo("Heads First Java");

        assertEquals(1, this.aMinhaBiblioteca.contarLivros());

        assertEquals(this.hobbit.obterResumo(), this.aMinhaBiblioteca.listarLivros());

    }


}