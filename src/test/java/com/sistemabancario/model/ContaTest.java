package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    
    @Test
    void testSetNumeroValido(){
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void estSetNumeroInvalido(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
    }
    
    @Test
    void estSetNumeroInvalidoArmazena(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotEquals(invalido, obtido);
    }
    
    @Test
    void testInstanciaPadraoConta(){
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    @Test
    void testsetlimitecontaespecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testSetLimiteContaNaoespecial(){
        final Conta instance = new Conta();
        final double esperado = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(esperado));
    }
    
    @Test
    void testSetLimiteContaNaoespecialalterado(){
        final Conta instance = new Conta();
        final double esperado = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(esperado));
        final double obtido = instance.getLimite();
        assertNotEquals(esperado, obtido);
    }
    
    @Test
    void testHistoriconotnull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
}
