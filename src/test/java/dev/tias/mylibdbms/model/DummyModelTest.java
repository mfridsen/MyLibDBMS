package dev.tias.mylibdbms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/30/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Unit Test for the DummyModel class.
 * <p>
 * Brought to you by copious amounts of nicotine.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DummyModelTest
{
    @BeforeAll
    static void setUp()
    {
    }

    @AfterAll
    static void tearDown()
    {
    }

    /**
     *
     */
    @Test
    @Order(1)
    void testDummyModel()
    {
        System.out.println("\n1: Testing DummyModel...");
        assertTrue(true); // This test will always pass
        System.out.println("\nTEST FINISHED.");
    }
}