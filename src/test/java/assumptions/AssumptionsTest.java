package assumptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assumptions.environment.JavaSpecification;
import assumptions.environment.OperationSystem;
import assumptions.environment.TestsEnvironment;

class AssumptionsTest {
	private static String JAVA_VERSION = "19";
	private TestsEnvironment env = new TestsEnvironment(
			new JavaSpecification(
					System.getProperty("java.vm.specification.version")),
			new OperationSystem(System.getProperty("os.name"),
					System.getProperty("os.arch")));

	private SUT systemUnderTest = new SUT();

	@BeforeEach
	void setUp() {
		assumeTrue(env.isWindows());
	}

	@Test
	void testNoJobToRun() {
		assumingThat(() -> env.getJavaVersion().equals(JAVA_VERSION),
				() -> assertFalse(systemUnderTest.hasJobToRun()));
	}

	@Test
	void testJobToRun() {
		assumeTrue(env.isAmd64Architecture());
		systemUnderTest.run(new Job());
		assertTrue(systemUnderTest.hasJobToRun());
	}
}
