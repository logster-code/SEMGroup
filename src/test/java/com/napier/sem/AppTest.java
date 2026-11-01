package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    // Test 1: Check regions message
    @Test
    void testRegionsMessage() {
        assertTrue(Main.regionsMessage.contains("Western Europe"));
        assertTrue(Main.regionsMessage.contains("Caribbean"));
        assertTrue(Main.regionsMessage.contains("Africa"));
    }

    // Test 2: Check continent message
    @Test
    void testContinentMessage() {
        assertTrue(Main.continentMessage.contains("Africa"));
        assertTrue(Main.continentMessage.contains("Europe"));
        assertTrue(Main.continentMessage.contains("Asia"));
        assertTrue(Main.continentMessage.contains("Oceania"));
    }

    // Test 3: Check regions message is not empty
    @Test
    void testRegionsMessageNotEmpty() {
        assertFalse(Main.regionsMessage.isEmpty());
    }

    // Test 4: Check continent message is not empty
    @Test
    void testContinentMessageNotEmpty() {
        assertFalse(Main.continentMessage.isEmpty());
    }

    // Test 5: Check inputs array length
    @Test
    void testInputsLength() {
        assertEquals(12, Main.inputs.length);
    }

    // Test 6: Check first input
    @Test
    void testFirstInput() {
        assertEquals("yes", Main.inputs[0]);
    }

    // Test 7: Check population limit input
    @Test
    void testPopulationLimitInput() {
        assertEquals("10", Main.inputs[1]);
    }

    // Test 8: Check continent input
    @Test
    void testContinentInput() {
        assertEquals("Europe", Main.inputs[4]);
    }

    // Test 9: Check region input
    @Test
    void testRegionInput() {
        assertEquals("Western Europe", Main.inputs[8]);
    }

    // Test 10: Check region population limit
    @Test
    void testRegionLimitInput() {
        assertEquals("5", Main.inputs[10]);
    }

}