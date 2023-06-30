package dev.tias.mylibdbms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/28/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Unit Test for the DatabaseConnector class.
 * <p>
 * Brought to you by copious amounts of nicotine.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseConnectorTest
{
    /**
     * Create the connection to the database.
     */
    @BeforeAll
    static void setup()
    {
        System.out.println("BeforeAll:");
        //TODO handle?
        DatabaseConnector.setVerbose(true);
        DatabaseConnector.setup();
    }

    /**
     * Always close the connection to the database after use.
     */
    @AfterAll
    static void tearDown()
    {
        System.out.println("Tearing down test environment...");
        DatabaseConnector.closeConnection();
    }

    /**
     * Tests the getConnection method of the DatabaseConnector class by asserting that the
     * connection object is not null.
     */
    @Test
    @Order(1)
    public void testConnection()
    {
        System.out.println("\n1: Testing connection...");
        System.out.println("Creating connection to database...");
        Connection connection = DatabaseConnector.getConnection();
        System.out.println("Asserting connection is not null, should be true: " + (connection != null));
        Assertions.assertNotNull(connection);
        DatabaseConnector.closeConnection();
        System.out.println("\nTEST FINISHED.");
    }

    /**
     * Tests the connectToDatabaseServer method of the DatabaseConnector class with an incorrect URL.
     * Expects a SQLException and asserts that the error message contains "Communications link failure".
     */
    @Test
    @Order(2)
    public void testConnectionWithIncorrectURL()
    {
        System.out.println("\n2: Attempting to connect to an invalid URL...");
        String url = "jdbc:mysql://localhost:3307"; // incorrect port number
        String user = "root";
        String password = "password";

        SQLException exception = assertThrows(SQLException.class, () ->
                DatabaseConnector.connectToDatabaseServer(url, user, password));

        String expectedMessage = "Communications link failure";
        String actualMessage = exception.getMessage();

        System.out.println("Asserting that error message contains '" + expectedMessage +
                "', should be true: " + actualMessage.contains(expectedMessage));
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("\nTEST FINISHED.");
    }

    /**
     * Tests the connectToDatabaseServer method of the DatabaseConnector class with an incorrect username.
     * Expects a SQLException and asserts that the error message contains "Access denied for user".
     */
    @Test
    @Order(3)
    public void testConnectionWithIncorrectUsername()
    {
        System.out.println("\n3: Attempting to connect with an invalid username...");
        String url = "jdbc:mysql://localhost:3306";
        String user = "badusername";
        String password = "password";

        SQLException exception = assertThrows(SQLException.class, () ->
                DatabaseConnector.connectToDatabaseServer(url, user, password));

        String expectedMessage = "Access denied for user";
        String actualMessage = exception.getMessage();

        System.out.println("Asserting that error message contains '" + expectedMessage +
                "', should be true: " + actualMessage.contains(expectedMessage));
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("\nTEST FINISHED.");
    }

    /**
     * Tests the connectToDatabaseServer method of the DatabaseConnector class with an incorrect username.
     * Expects a SQLException and asserts that the error message contains "Access denied for user".
     */
    @Test
    @Order(4)
    public void testConnectionWithIncorrectPassword()
    {
        System.out.println("\n4: Attempting to connect with an invalid password...");
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "badpassword";

        SQLException exception = assertThrows(SQLException.class, () ->
                DatabaseConnector.connectToDatabaseServer(url, user, password));

        String expectedMessage = "Access denied for user";
        String actualMessage = exception.getMessage();

        System.out.println("Asserting that error message contains '" + expectedMessage +
                "', should be true: " + actualMessage.contains(expectedMessage));
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("\nTEST FINISHED.");
    }
}