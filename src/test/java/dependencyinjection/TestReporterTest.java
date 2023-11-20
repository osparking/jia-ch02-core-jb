package dependencyinjection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class TestReporterTest {
	
	@Test
	void testReportSingleValue(TestReporter testReporter) {
		testReporter.publishEntry("single value");
	}
	
	@Test
	void testReportKeyValuePair(TestReporter testReporter) {
		testReporter.publishEntry("value", "single value");
	}
}
