package newtours;

import asquared.TestRegistrationXpath;
import asquared.TestVariables1;
import asquared.TestVerifyLinks1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
/**
 * This is a Suite file to execute multiple test classes at once.
 */
@Suite.SuiteClasses({
        TestVariables1.class,
        TestVerifyLinks1.class,
        TestRegistrationXpath.class
})
public class newtoursSuite {
}
