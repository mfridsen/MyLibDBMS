package dev.tias.mylibdbms.view;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/30/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Test Suite for all the test classes related to the View part of this application.
 * <p>
 * Calls all the test classes and/or suites in the view package.
 */
@Suite
@SelectClasses({
        DummyViewTest.class,
})
public class ViewTestSuite
{
}