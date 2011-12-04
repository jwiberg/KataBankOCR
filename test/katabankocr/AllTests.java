package katabankocr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountFileParserTests.class, AccountTests.class,
		LogWriterTests.class, LogFileWriterTests.class })
public class AllTests {
}
