package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedWithCsvSourceTest {
	private WordCounter wordCounter = new WordCounter();
	
	@ParameterizedTest
	@CsvSource({"2, 단위 시험", "3, JUnit in action", "4, 월 화 수 목"})
	void testWordsInSentence(int expected, String sentence) {
		assertEquals(expected, wordCounter.countWords(sentence));
	}
	
}
