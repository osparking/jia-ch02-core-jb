package dependencyinjection;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class TestReporterTest {
	
	@Test
	void testReportKeyValuePair(TestReporter testReporter) {
		testReporter.publishEntry("key", "single value");
	}
	
	@Test
	void testReportKeyValueMap(TestReporter testReporter) {
		Map<String, String> values = new HashMap<>();
		values.put("user", "kdhong");
		values.put("password", "secret");
		testReporter.publishEntry(values);
	}
}
