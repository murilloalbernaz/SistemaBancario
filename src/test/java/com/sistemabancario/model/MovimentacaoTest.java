package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste base para implementação dos testes
 * unitários para a classe {@link Movimentacao}.
 * Os testes foram gerados pelo IDE apenas como modelo
 * (fiz apenas algumas melhorias de boas práticas 
 * como tirar visibilidade public e definir variáveis como final).
 * 
 * Assim, NENHUM DELES FUNCIONA E O CÓDIGO PRECISA SER ALTERADO
 * de acordo com as regras de negócio dos métodos da classe {@link Movimentacao}.
 * Ao iniciar a alteração de um teste aqui,
 * a primeira coisa a fazer é remover a chamada de fail(),
 * que indica que o teste é apenas um protótipo.
 * 
 * @author Manoel Campos da Silva Filho
 */
class MovimentacaoTest {
    @Test
    void testGetId() {
        final Movimentacao instance = new Movimentacao(new Conta());
        final long esperado = 1;
        instance.setId(esperado);
        final long obtido = instance.getId();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void SetTipoCorreto(){
       Movimentacao instance = new Movimentacao(new Conta());
       final char esperado = 'C';
       instance.setTipo(esperado);
       final char obtido = instance.getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void SetTipoErrado(){
       Movimentacao instance = new Movimentacao(new Conta());
       final char esperado = 'F';
       assertThrows(IllegalArgumentException.class, () -> instance.setTipo(esperado));
    }
    
    @Test
    void SetValorCorreto(){
        Movimentacao instance = new Movimentacao(new Conta());
        instance.setTipo('C');
        final double esperado = 22000.22;
        instance.setValor(esperado);
        final double obtido = instance.getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void SetValorErrado(){
        Movimentacao instance = new Movimentacao(new Conta());
        final double esperado = -22000.22;
        assertThrows(IllegalArgumentException.class, () -> instance.setValor(esperado));
    }
    
    @Test
    void Confirmada(){
        Movimentacao instance = new Movimentacao(new Conta());
        final boolean esperado = true;
        final boolean obtido = instance.isConfirmada();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void Conta(){
        Conta esperado = new Conta();
        Movimentacao instance = new Movimentacao(esperado);
        final Conta obtido = instance.getConta();
        assertEquals(esperado, obtido);
    }

}
