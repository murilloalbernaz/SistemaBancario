package com.sistemabancario.model;

import java.util.ArrayList;
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
    
    @Test 
    void testGetSaldoTotal(){
        final double limite = 500;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiro(){
        final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }
    
    @Test
    void TestDepositoDinheirotipo(){
        final double deposito = 500.8;
        final char esperado = 'C';
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        final ArrayList<Movimentacao> movimentacoes = (ArrayList<Movimentacao>) instance.getMovimentacoes();
        final char obtido = movimentacoes.get(0).getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void TestDepositoDinheiroConfirmada(){
        final double deposito = 500.8;
        final boolean esperado = true;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        final ArrayList<Movimentacao> movimentacoes = (ArrayList<Movimentacao>) instance.getMovimentacoes();
        final boolean obtido = movimentacoes.get(0).isConfirmada();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void TestDepositoDinheiroValorAtribuido(){
        final double deposito = 500.8;
        final double esperado = 500.8;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        final ArrayList<Movimentacao> movimentacoes = (ArrayList<Movimentacao>) instance.getMovimentacoes();
        final double obtido = movimentacoes.get(0).getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void TestDepositoDinheiroListanaoNulla(){
        final double deposito = 500.8;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        assertNotNull(instance.getMovimentacoes());
    }
        
    @Test
    void TestDepositoDinheironegativo(){
        final double deposito = -500;
        final Conta instance = new Conta();
        
        assertThrows(IllegalArgumentException.class, () ->instance.depositoDinheiro(deposito));
    }
    
}
