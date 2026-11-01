package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{

    @Test
    void testRegionsMessage() {
        assertTrue(Main.regionsMessage.contains("Western Europe"));
        assertTrue(Main.regionsMessage.contains("Caribbean"));
        assertTrue(Main.regionsMessage.contains("Africa"));
    }

    @Test
    void testContinentMessage() {
        assertTrue(Main.continentMessage.contains("Africa"));
        assertTrue(Main.continentMessage.contains("Europe"));
        assertTrue(Main.continentMessage.contains("Asia"));
        assertTrue(Main.continentMessage.contains("Oceania"));
    }

    @Test
    void testRegionsMessageNotEmpty() {
        assertFalse(Main.regionsMessage.isEmpty());
    }

    @Test
    void testContinentMessageNotEmpty() {
        assertFalse(Main.continentMessage.isEmpty());
    }

    @Test
    void testInputsLength() {
        assertEquals(26, Main.inputs.length);
    }

    @Test
    void testFirstInput() {
        assertEquals("yes", Main.inputs[0]);
    }

    @Test
    void testPopulationLimitInput() {
        assertEquals("10", Main.inputs[1]);
    }

    @Test
    void testContinentInput() {
        assertEquals("Europe", Main.inputs[4]);
    }

    @Test
    void testRegionInput() {
        assertEquals("Western Europe", Main.inputs[8]);
    }

    @Test
    void testRegionLimitInput() {
        assertEquals("5", Main.inputs[10]);
    }

    @Test
    void testInitialConnection()
    {
        Main app = new Main();

        assertNull(app.getConnection());
    }

    @Test
    void testDisconnectWithoutConnection()
    {
        Main app = new Main();

        app.disconnect();

        assertNull(app.getConnection());
    }
}