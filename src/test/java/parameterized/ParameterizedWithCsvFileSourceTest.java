package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedWithCsvFileSourceTest {
	private final WordCounter wordCounter = new WordCounter();
	
	@ParameterizedTest
	@CsvFileSource(resources = "/words_in_string.csv")
	void testWordCountInSentence(int expected, String sentence) {
		assertEquals(expected, wordCounter.countWords(sentence));
	}
}
