package dev.tias.mylibdbms.service;

import java.util.logging.Logger;

import static org.junit.Assert.fail;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @package dev.tias.mylibdbms.model
 * @contact matfir-1@student.ltu.se
 * @date 6/29/2023
 * <p>
 * We plan as much as we can (based on the knowledge available),
 * When we can (based on the time and resources available),
 * But not before.
 * <p>
 * Brought to you by enough nicotine to kill a large horse.
 */
public class ExceptionManager
{
    public static void HandleFatalException(Throwable cause)
    {
        System.err.println("A fatal error occurred: ");
        System.err.println("Cause message: " + cause.getMessage());
        cause.printStackTrace();
        System.exit(1);
    }

    public static void HandleFatalException(Throwable cause, String message)
    {
        System.err.println("A fatal error occurred with message: ");
        System.err.println(message);
        System.err.println("Cause message: " + cause.getMessage());
        cause.printStackTrace();
        System.exit(1);
    }

    public static void HandleTestException(Throwable cause)
    {
        System.err.println("An unexpected exception occurred during test with message: ");
        System.err.println(cause.getMessage());
        System.err.println("Stack trace: ");
        cause.printStackTrace();
        fail();
    }
}