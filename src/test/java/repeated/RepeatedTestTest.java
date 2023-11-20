package repeated;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

class RepeatedTestTest {
	
	@RepeatedTest(value = 5, name =
			"{displayName} - 회차 {currentRepetition}/{totalRepetitions}")
	@DisplayName("add 연산 시험")
	void addNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 은 2 이다.");
	}

	private static Set<Integer> integerSet = new HashSet<>();
	private static List<Integer> integerList = new ArrayList<>();
	
	@RepeatedTest(value =5, 
			name = "Current line #: {currentRepetition}, Set element count: 1" )
	void testAddingToCollections(TestReporter testReporter, 
			RepetitionInfo repetitionInfo) {
		integerSet.add(1);
		integerList.add(repetitionInfo.getCurrentRepetition());
		
		testReporter.publishEntry("Repetition odrer", 
				String.valueOf(repetitionInfo.getCurrentRepetition()));
		
		assertEquals(1, integerSet.size());
		assertEquals(repetitionInfo.getCurrentRepetition(), integerList.size());
		
	}
}
