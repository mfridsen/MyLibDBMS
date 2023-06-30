package dev.tias.mylibdbms.service.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mattias Fridsén
 * @project LibraryDBMS
 * @package edu.groupeighteen.librarydbms.model.db
 * @contact matfir-1@student.ltu.se
 * @date 5/8/2023
 * <p>
 * A utility class representing the result of a SQL query execution. This class is designed to encapsulate both the
 * ResultSet and the Statement, allowing for easier management of resources, especially when closing the ResultSet and
 * the Statement.
 * <p>
 * Implements {@link AutoCloseable} in order to be used with try-with-resources.
 */
public record QueryResult(ResultSet resultSet, Statement statement) implements AutoCloseable
{
    /**
     * Closes both the ResultSet and the Statement associated with this QueryResult object. Any SQLExceptions thrown
     * during the closing process are caught and handled within this method.
     */
    @Override
    public void close()
    {
        try
        {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
        }
        catch (SQLException e)
        {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
}