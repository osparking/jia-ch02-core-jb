package assertions;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;

public class AssertTimeoutTest {
	private SUT systemUnderTest = new SUT("시험될 우리 시스템");
	
	@Test
	@DisplayName("조기 종료 가능성 있었으나, 500ms 내 작업 성공적으로 종료함")
	void testTimeoutPreemptively() throws InterruptedException {
		systemUnderTest.addJob(new Job("A Job that takes more than 500ms"));
		assertTimeoutPreemptively(ofMillis(500), 
				() -> systemUnderTest.run(600));
	}
	
	@Test
	@DisplayName("500ms 내에 작업이 수행됨")
	void testTimeout() throws InterruptedException {
		systemUnderTest.addJob(new Job("A Job that takes about 200ms"));
		assertTimeout(ofMillis(500), () -> systemUnderTest.run(200));
	}
}
