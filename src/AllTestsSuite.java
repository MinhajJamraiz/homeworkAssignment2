import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.ChainingExceptionDemoTest;
import tests.MultipleExceptionDemoTest;
import tests.ResourceManagementDemoTest;
import tests.RethrowExceptionDemoTest;

@Suite
@SelectClasses({
    MultipleExceptionDemoTest.class,
    RethrowExceptionDemoTest.class,
    ResourceManagementDemoTest.class,
    ChainingExceptionDemoTest.class
})
public class AllTestsSuite {
}