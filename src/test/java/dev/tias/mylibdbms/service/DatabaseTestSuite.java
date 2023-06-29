package dev.tias.mylibdbms.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/29/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Test Suite for all the test classes related to the Database part of this application.
 * Calls all the test classes in the database package. Is itself called by the ApplicationTestSuite class.
 * <p>
 * Brought to you by copious amounts of nicotine.
 */
@Suite
@SelectClasses({
        DatabaseConnectorTest.class,
})
public class DatabaseTestSuite
{
}