/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class ManipulacaoStringsTest {

    private final ManipulacaoStrings stringUtils;

    public ManipulacaoStringsTest() {
        this.stringUtils = new ManipulacaoStrings();
    }

    /**
     * Test of isEmpty method, of class StringUtils.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertTrue(stringUtils.isEmpty(" "));
        assertFalse(stringUtils.isEmpty("a"));
        assertFalse(stringUtils.isEmpty(" a "));
    }

    /**
     * Test of inverter method, of class StringUtils.
     */
    @Test
    public void testInverter() {
        assertEquals("solrac", stringUtils.inverter("carlos"));
    }

    /**
     * Test of contaVogais method, of class StringUtils.
     */
    @Test
    public void testContaVogais() {
        assertEquals(2, stringUtils.contaVogais("carlos"));
    }

    /**
     * Test of isPalindromo method, of class StringUtils.
     */
    @Test
    public void testIsPalindromo() {
        assertTrue(stringUtils.isPalindromo("ovo"));
        assertTrue(stringUtils.isPalindromo("Ame a Ema"));
        assertTrue(stringUtils.isPalindromo("A sogra ma e amargosa"));
        assertFalse(stringUtils.isPalindromo("uva"));
        assertFalse(stringUtils.isPalindromo("Ame a Emo"));
    }

}