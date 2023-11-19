package assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertThrowsTest {
	private SUT systemUnderTest = new SUT("시험될 우리 시스템");

	@Test
	@DisplayName("예상하는 대로 예외가 던저졌다.")
	void testExceptionThrows() {
		assertThrows(NoJobException.class, systemUnderTest::run);
	}
	
	@Test
	@DisplayName("발생 예외 메시지가 기대치와 같다.")
	void testExceptionMessage() {
		Throwable th = assertThrows(NoJobException.class, 
				() -> systemUnderTest.run(1000));
		assertEquals("No jobs on the execution list!",th.getMessage());
	}
	
}
