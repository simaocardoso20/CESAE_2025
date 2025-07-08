import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parteA.tempo.Relogio;

import static org.junit.jupiter.api.Assertions.*;

class RelogioTest {
    Relogio relogio1;
    Relogio relogio2;

    @BeforeEach
    void setUp() {
        relogio1 = new Relogio("casio", 21, 30, 10, 2000);
        relogio2 = new Relogio("Rolex", 14, 15, 20, 2010);
    }

    @Test
    public void testAjustarHora() {
        assertEquals(21, relogio1.getHora());
        relogio1.ajustarHora(22);
        assertEquals(22, relogio1.getHora());
    }

    @Test
    public void testAjustarMinutos() {
        assertEquals(30, relogio1.getMinuto());
        relogio1.ajustarMinutos(50);
        assertEquals(50, relogio1.getMinuto());
    }

    @Test
    public void testAjustarMinutosZero() {
        assertEquals(30, relogio1.getMinuto());
        relogio1.ajustarMinutos(00);
        assertEquals(00, relogio1.getMinuto());
    }

    @Test
    public void testAjustarMinutosInvalido() {
        assertEquals(30, relogio1.getMinuto());
        relogio1.ajustarMinutos(60);
        assertEquals(60, relogio1.getMinuto());
    }

    @Test
    public void testAjustarSegundos() {
        assertEquals(10, relogio1.getSegundo());
        relogio1.ajustarSegundos(40);
        assertEquals(40, relogio1.getSegundo());
    }
    @Test
    public void testAjustarSegundosZero() {
        assertEquals(10, relogio1.getSegundo());
        relogio1.ajustarSegundos(00);
        assertEquals(00, relogio1.getSegundo());
    }

    @Test
    public void testAjustarSegundosInvalido() {
        assertEquals(10, relogio1.getSegundo());
        relogio1.ajustarSegundos(60);
        assertEquals(60, relogio1.getSegundo());
    }

    @Test
    public void testPassarUmSegundo() {
        assertEquals(10, relogio1.getSegundo());
        relogio1.passarUmSegundo();
        assertEquals(11, relogio1.getSegundo());
        assertEquals(30, relogio1.getMinuto());
        assertEquals(21, relogio1.getHora());
    }

    @Test
    public void TestPassarSegundos() {
        assertEquals(10, relogio1.getSegundo());
        relogio1.passarSegundos(11);
        assertEquals(11, relogio1.getSegundo());
    }

    @Test
    public void testConverterParaSegundos() {
        int resultado = relogio1.converterParaSegundos();
        // Valor calculado com bug: 21*360 + 30*60 + 10 = 7560 + 1800 + 10 = 9370
        assertEquals(79210, resultado);
    }


}