package dev.tias.mylibdbms.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/30/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Unit Test for the DummyView class.
 * <p>
 * Brought to you by copious amounts of nicotine.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DummyViewTest
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
    void testDummyView()
    {
        System.out.println("\n1: Testing DummyView...");
        assertTrue(true); // This test will always pass
        System.out.println("\nTEST FINISHED.");
    }
}