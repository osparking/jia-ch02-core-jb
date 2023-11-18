package assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertAllTest {

	@Test
	@DisplayName("SUT 는 기본적으로 현재 검증 중인 것이 아니어야 함")
	void testSystemNotVerified() {
		SUT systemUnderTest = new SUT("시험 중인 우리 시스템");

		assertAll("기본적으로, SUT 는 현재 검증 중인 것이 아니어야 함",
				() -> assertEquals("시험 중인 우리 시스템", 
						systemUnderTest.getSystemName()),
				() -> assertFalse(systemUnderTest.isVerified()));
	}
	
	@Test
	@DisplayName("SUT 는 현재 검증 중인 것이어야 함")
	void testSystemUnderVerified() {
		String systemName = "시험 중인 우리 시스템";
		SUT systemUnderTest = new SUT(systemName);
		
		assertAll("SUT는 현재 검증 중임",
				() -> assertEquals(systemName, 
						systemUnderTest.getSystemName()),
				() -> assertTrue(systemUnderTest.isVerified()));
	}

}
