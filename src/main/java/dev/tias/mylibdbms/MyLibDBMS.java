package dev.tias.mylibdbms;

import dev.tias.mylibdbms.service.DatabaseConnector;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @package dev.tias.mylibdbms
 * @contact matfir-1@student.ltu.se
 * @date 6/25/2023
 * <p>
 * We plan as much as we can (based on the knowledge available),
 * When we can (based on the time and resources available),
 * But not before.
 * <p>
 * Brought to you by enough nicotine to kill a large horse.
 */
public class MyLibDBMS //TODO-prio extend Runnable?
{
    //Name of the database
    public static final String databaseName = "lilla_biblioteket";

    //Current/Logged in user of the system
    //private static User currentUser = null;

    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }

    /**
     * Exits the program with status. If the connection to the database is still active, closes it.
     */
    public static void exit(int status)
    {
        //Always close the connection to the database after use
        if (DatabaseConnector.getConnection() != null)
            DatabaseConnector.closeConnection();
        System.exit(status);
    }
}