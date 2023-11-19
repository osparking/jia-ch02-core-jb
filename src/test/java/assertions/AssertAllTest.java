package assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertAllTest {
	String systemName = "검증 대상 우리 시스템";
	SUT systemUnderTest = new SUT(systemName);
	
	@Test
	@DisplayName("시스템은 현재 검증되고 있지 않다.")
	void testSysNotUnderVerif() {
		assertFalse(systemUnderTest.isVerified(),
				() -> "'" + systemName +"'은 현재 검증되고 있지 않아야 함.");
	}
	
	@Test
	@DisplayName("SUT는 현재 검증되고 있어야 함")
	void testSystemUnderVerification() {
		String systemName = "검증 대상 우리 시스템";
		SUT systemUnderTest = new SUT(systemName);
		systemUnderTest.verify();
		assertTrue(systemUnderTest.isVerified(),
				() -> systemName +"는 현재 검증되고 있어야 함");
	}

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
		
		systemUnderTest.verify();
		
		assertAll("SUT는 현재 검증 중임",
				() -> assertEquals(systemName, 
						systemUnderTest.getSystemName()),
				() -> assertTrue(systemUnderTest.isVerified()));
	}

}
