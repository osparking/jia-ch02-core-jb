package repeated;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RepeatedTestTest {
	
	@RepeatedTest(value = 5, name =
			"{displayName} - 회차 {currentRepetition}/{totalRepetitions}")
	@DisplayName("add 연산 시험")
	void addNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 은 2 이다.");
	}

}
