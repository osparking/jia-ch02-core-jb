package displayname;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("DisplayName 애노테이션 시험 클래스")
public class DisplayNameTest {
	
	private SUT systemUnderTest = new SUT();
	
	@Test
	@DisplayName("시험 대상 시스템이 안녕이라 인사한다.")
	void testHello() {
		assertEquals("안녕", systemUnderTest.hello());
	}
	
	@Test
	@DisplayName("👋")
	void testGreet() {
		assertEquals("어떻게 지내세요?", systemUnderTest.greet());
	}
	
	@Test
	void testGoodBye() {
		assertEquals("잘가", systemUnderTest.goodBye());
	}

}
