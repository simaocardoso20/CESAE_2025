package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    Livro headsFirstJava;
    Livro hobbit;

    @BeforeEach
    void setUp() {
        this.headsFirstJava = new Livro("Heads First Java", "Kathy Sierra", 2015, 760);
        this.hobbit = new Livro("Hobbit", "Tolkien", 2000, 600);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Heads First Java", this.headsFirstJava.getTitulo());
        assertEquals("Hobbit", this.hobbit.getTitulo());
    }

    @Test
    public void testAlterarTitulo() {
        assertEquals("Heads First Java", this.headsFirstJava.getTitulo());
        this.headsFirstJava.alterarTitulo("Heads First Python");
        assertEquals("Heads First Python", this.headsFirstJava.getTitulo());
        this.headsFirstJava.alterarTitulo("Heads First C++");
        assertEquals("Heads First C++", this.headsFirstJava.getTitulo());

    }

    @Test
    public void testEmprestarLivroDisponivel() {
        assertTrue(this.headsFirstJava.estaDisponivel());
        this.headsFirstJava.emprestar();
        assertFalse(this.headsFirstJava.estaDisponivel());

        // CONTROLO
        assertTrue(this.hobbit.estaDisponivel());
        this.hobbit.emprestar();
        assertFalse(this.hobbit.estaDisponivel());
    }

    @Test
    public void testEmprestarLivroIndisponivel(){
        this.headsFirstJava.emprestar();
        assertFalse(this.headsFirstJava.estaDisponivel());
        this.headsFirstJava.emprestar();
        assertFalse(this.headsFirstJava.estaDisponivel());

        // CONTROLO
        this.hobbit.emprestar();
        assertFalse(this.hobbit.estaDisponivel());
        this.hobbit.emprestar();
        assertFalse(this.hobbit.estaDisponivel());
    }

    @Test
    public void testRecepcionarLivroEmprestado(){
        this.headsFirstJava.emprestar();
        this.headsFirstJava.recepcionar();
        assertTrue(this.headsFirstJava.estaDisponivel());
    }
}