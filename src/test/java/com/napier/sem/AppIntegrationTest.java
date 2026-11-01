package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest
{
    static Main app;

    @BeforeAll
    static void init()
    {
        app = new Main();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testAllCountriesByPop()
    {

    }
}