package disabled;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import displayname.SUT;

class DisabledTestMethods {
	
	private SUT sUTest = new SUT("시험 대상 우리 시스템");
	
	@Test
	@Disabled
	void testRegularWork() {
		boolean regular = sUTest.canReceiveRegularWork();
		assertTrue(regular);
	}
	
	@Test
	@Disabled("아직도 개발 중...")
	void testAddedWork() {
		boolean addided = sUTest.canReceiveAdditionWork();
		assertFalse(addided);
	}
}
