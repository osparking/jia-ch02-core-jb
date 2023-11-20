package dependencyinjection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TestInfoTest {

	TestInfoTest(TestInfo testInfo) {
		super();
		assertEquals("TestInfoTest", testInfo.getDisplayName());
	}
	
	@BeforeEach
	void setUp(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(
				displayName.equals("testGetNameOfTheMethod(TestInfo)") ||
				displayName.equals("메소드의 게시되는 이름")
		);
	}
	
	@Test
	void testGetNameOfTheMethod(TestInfo testInfo) {
		assertEquals("testGetNameOfTheMethod(TestInfo)", 
				testInfo.getDisplayName());
	}
	
	@Test
	@DisplayName("메소드의 게시되는 이름")
	void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
		assertEquals("메소드의 게시되는 이름", testInfo.getDisplayName());
	}
}
