package disabled;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import displayname.SUT;

@Disabled("이 시험 클래스는 아직 미완성")
public class DisabledClassTest {
	
	private SUT systemUnderTest = new SUT("시험받는 우리 시스템");

	@Test
	void testRegularWork() {
		boolean canRegular = systemUnderTest.canReceiveRegularWork();
		assertTrue(canRegular);
	}
	
	@Test
	void testAdditionWork() {
		boolean canRegular = systemUnderTest.canReceiveAdditionWork();
		assertFalse(canRegular);
	}
	
}
