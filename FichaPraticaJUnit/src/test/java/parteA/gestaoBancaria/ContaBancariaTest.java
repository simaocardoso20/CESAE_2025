package parteA.gestaoBancaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaTest {
    ContaBancaria conta1;
    ContaBancaria conta2;

    @BeforeEach
    void setUp() {
        conta1 = new ContaBancaria("Pedro", 1000, 2025, "Portugal", "PT50232323232323");
        conta2 = new ContaBancaria("Rui", 2000, 2025, "Portugal", "PT323232323232");
    }

    @Test
    void testDepositar() {
        conta1.depositar(50);
        assertEquals(1050.0, conta1.consultarSaldo());

        conta1.depositar(100.0);
        assertEquals(1150.0, conta1.consultarSaldo());
    }

    @Test
    public void testlevantarValorMenorSaldo() {
        conta1.levantar(500);
        assertEquals(500.0, conta1.consultarSaldo());
    }

    @Test
    public void testlevantarIgualSaldo() {
        conta1.levantar(1000);
        assertEquals(0.0, conta1.consultarSaldo());
    }

    @Test
    public void testlevantarMaisSaldo() {
        conta1.levantar(1500.0);
        assertEquals(1000, conta1.consultarSaldo());
    }

    @Test
    public void levantarValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            conta1.levantar(-1000);
        });
    }

    @Test
    public void transferirValorMenorSaldo() {
        conta1.transferir(conta2, 300.0);
        assertEquals(700.0, conta1.consultarSaldo());
        assertEquals(2300.0, conta2.consultarSaldo());
    }

    @Test
    public void transferirValorIgualSaldo() {
        conta1.transferir(conta2, 1000.0);
        assertEquals(0.0, conta1.consultarSaldo());
        assertEquals(3000.0, conta2.consultarSaldo());
    }

    @Test
    public void transferirValorMaiorSaldo() {
        conta1.transferir(conta2, 1500.0);
        assertEquals(1000.0, conta1.consultarSaldo());
        assertEquals(2000.0, conta2.consultarSaldo());
    }

    @Test
    public void transferirValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            conta1.transferir(conta2, -1500.0);
        });
    }
}








