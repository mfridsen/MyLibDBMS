package dev.tias.mylibdbms.db;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @package dev.tias.mylibdbms.db
 * @contact matfir-1@student.ltu.se
 * @date 6/28/2023
 * <p>
 * We plan as much as we can (based on the knowledge available),
 * When we can (based on the time and resources available),
 * But not before.
 * <p>
 * Brought to you by enough nicotine to kill a large horse.
 */
public class DatabaseConnector
{
    private static Connection connection = null;

    //Print commands being run, default = not
    private static boolean verbose = false;

    /**
     * Standard connection method for a default-configured local MySQL Server. Connects to the server
     * using the connectToDatabaseServer method. Connects with the following parameters:
     * user: root
     * password: password
     * url: jdbc:mysql://localhost:3306
     * server: localhost
     * port: 3306
     */
    public static void setup() //TODO-exceptions catch here
    throws SQLException, ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306";
        String user = null;
        String password = null;

        try
        {
            // Read the user and password from config.json
            Gson gson = new Gson();
            JsonElement config = gson.fromJson(new FileReader("src/main/resources/config.json"),
                    JsonElement.class);
            user = config.getAsJsonObject().get("user").getAsString();
            password = config.getAsJsonObject().get("password").getAsString();
        }
        catch (IOException e) //TODO-exception
        {
            // Handle any exceptions that might occur while reading the file
        }

        connectToDatabaseServer(url, user, password);
    }

    /**
     * This method connects the Java application to a specific database. It loads the JDBC driver
     * and then establishes a connection to the database using the provided url, user, and password parameters.
     * If there are any errors connecting to the database, the method will throw a ClassNotFoundException
     * or SQLException.
     *
     * @param url      the URL of the database to connect to
     * @param user     the username to use when connecting to the database
     * @param password the password to use when connecting to the database
     */
    public static void connectToDatabaseServer(String url, String user, String password)
    throws SQLException, ClassNotFoundException
    {
        // Load the JDBC driver
        if (verbose) System.out.println("\nLoading JDBC driver...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (verbose) System.out.println("Loaded JDBC driver.");

        // Establish a connection
        if (verbose) System.out.println("Connecting to: " + user + "@" + url);
        connection = DriverManager.getConnection(url, user, password);
        if (verbose) System.out.println("Connected to: " + user + "@" + url);
    }

    /**
     * Closes the connection.
     */
    public static void closeConnection()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Getters and setters are self-explanatory.
     */
    public static Connection getConnection()
    {
        return connection;
    }

    public static boolean isVerbose()
    {
        return verbose;
    }

    public static void setVerbose(boolean verbose)
    {
        DatabaseConnector.verbose = verbose;
    }
}