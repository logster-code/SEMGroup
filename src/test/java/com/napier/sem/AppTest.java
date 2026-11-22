package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type App test.
 */
public class AppTest {
    /**
     * Test class containing all tests for the Main app class
     */
    @Test
    void testRegionsMessage() {
        assertTrue(Main.regionsMessage.contains("Western Europe"));
        assertTrue(Main.regionsMessage.contains("Caribbean"));
        assertTrue(Main.regionsMessage.contains("Africa"));
    }

    /**
     * Test continent message.
     */
    @Test
    void testContinentMessage() {
        assertTrue(Main.continentMessage.contains("Africa"));
        assertTrue(Main.continentMessage.contains("Europe"));
        assertTrue(Main.continentMessage.contains("Asia"));
        assertTrue(Main.continentMessage.contains("Oceania"));
    }

    /**
     * Test regions message not empty.
     */
    @Test
    void testRegionsMessageNotEmpty() {
        assertFalse(Main.regionsMessage.isEmpty());
    }

    /**
     * Test continent message not empty.
     */
    @Test
    void testContinentMessageNotEmpty() {
        assertFalse(Main.continentMessage.isEmpty());
    }

    /**
     * Test inputs length.
     */
    @Test
    void testInputsLength() {assertEquals(36, Main.inputs.length);}

    /**
     * Test first input.
     */
    @Test
    void testFirstInput() {
        assertEquals("yes", Main.inputs[0]);
    }

    /**
     * Test population limit input.
     */
    @Test
    void testPopulationLimitInput() {
        assertEquals("10", Main.inputs[1]);
    }

    /**
     * Test continent input.
     */
    @Test
    void testContinentInput() {
        assertEquals("Europe", Main.inputs[4]);
    }

    /**
     * Test region input.
     */
    @Test
    void testRegionInput() {
        assertEquals("Western Europe", Main.inputs[8]);
    }

    /**
     * Test region limit input.
     */
    @Test
    void testRegionLimitInput() {
        assertEquals("5", Main.inputs[10]);
    }

    /**
     * Test initial connection.
     */
    @Test
    void testInitialConnection() {
        Main app = new Main();

        assertNull(app.getConnection());
    }

    /**
     * Test disconnect without connection.
     */
    @Test
    void testDisconnectWithoutConnection() {
        Main app = new Main();

        app.disconnect();

        assertNull(app.getConnection());
    }

    /**
     * Test city first input.
     */
    @Test
    void testCityFirstInput() {
        assertEquals("yes", Main.inputs[12]);
    }

    /**
     * Test city population limit input.
     */
    @Test
    void testCityPopulationLimitInput() {
        assertEquals("10", Main.inputs[13]);
    }

    /**
     * Test city continent input.
     */
    @Test
    void testCityContinentInput() {
        assertEquals("Europe", Main.inputs[15]);
    }

    /**
     * Test city region input.
     */
    @Test
    void testCityRegionInput() {
        assertEquals("Western Europe", Main.inputs[18]);
    }

    /**
     * Test city country input.
     */
    @Test
    void testCityCountryInput() {
        assertEquals("United Kingdom", Main.inputs[21]);
    }

    /**
     * Test city district input.
     */
    @Test
    void testCityDistrictInput() {
        assertEquals("England", Main.inputs[24]);
    }

    /**
     * Test capital cities first input.
     */
    @Test
    void testCapitalCitiesFirstInput() {assertEquals("yes", Main.inputs[26]);}

    /**
     * Test capital cities population limit input.
     */
    @Test
    void testCapitalCitiesPopulationLimitInput() {assertEquals("10", Main.inputs[27]);}

    /**
     * Test capital cities continent input.
     */
    @Test
    void testCapitalCitiesContinentInput() {assertEquals("Europe", Main.inputs[29]);}

    /**
     * Test capital cities continent limit choice.
     */
    @Test
    void testCapitalCitiesContinentLimitChoice() {assertEquals("yes", Main.inputs[30]);}

    /**
     * Test capital cities continent limit input.
     */
    @Test
    void testCapitalCitiesContinentLimitInput() {assertEquals("5", Main.inputs[31]);}

    /**
     * Test capital cities region input.
     */
    @Test
    void testCapitalCitiesRegionInput() {assertEquals("Western Europe", Main.inputs[33]);}

    /**
     * Test capital cities region limit choice.
     */
    @Test
    void testCapitalCitiesRegionLimitChoice() {assertEquals("yes", Main.inputs[34]);}

    /**
     * Test capital cities region limit input.
     */
    @Test
    void testCapitalCitiesRegionLimitInput() {assertEquals("5", Main.inputs[35]);}
}