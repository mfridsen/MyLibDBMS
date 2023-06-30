package dev.tias.mylibdbms.model;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/30/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Test Suite for all the test classes related to the Model part of this application. Calls all the test classes in the
 * model package.
 */
@Suite
@SelectClasses({
        DummyModelTest.class,
})
public class ModelTestSuite
{
}