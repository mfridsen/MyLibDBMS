package dev.tias.mylibdbms;

import dev.tias.mylibdbms.control.ControlTestSuite;
import dev.tias.mylibdbms.model.ModelTestSuite;
import dev.tias.mylibdbms.service.db.DatabaseTestSuite;
import dev.tias.mylibdbms.view.ViewTestSuite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author Mattias Fridsén
 * @project MyLibDBMS
 * @date 6/29/2023
 * @contact matfir-1@student.ltu.se
 * <p>
 * Test Suite for the entire application.
 * <p>
 * Brought to you by copious amounts of nicotine.
 */
@Suite
@SelectClasses({
        DatabaseTestSuite.class,
        ModelTestSuite.class,
        ControlTestSuite.class,
        ViewTestSuite.class
})
public class MyLibDBMSTestSuite
{
}