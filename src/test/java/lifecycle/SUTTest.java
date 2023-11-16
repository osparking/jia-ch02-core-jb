package lifecycle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SUTTest {
	private static ResourceForAllTests resourceForAllTests;
	private SUT systemUnderTest;

	@BeforeAll // #1
	static void setUpClass() {
		resourceForAllTests = new ResourceForAllTests("모든 시험 전에 필요한 자원");
	}

	@AfterAll // #2
	static void tearDownClass() {
		resourceForAllTests.close();
	}

	@BeforeEach // #3
	void setUp() {
		systemUnderTest = new SUT("시험 중인 우리 시스템");
	}

	@AfterEach // #4
	void tearDown() {
		systemUnderTest.close();
	}

	@Test // #5
	void testRegularWork() {
		boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();

		assertTrue(canReceiveRegularWork);
	}

	@Test // #5
	void testAdditionalWork() {
		boolean canReceiveAdditionalWork = systemUnderTest
				.canReceiveAdditionalWork();

		assertFalse(canReceiveAdditionalWork);
	}
}
