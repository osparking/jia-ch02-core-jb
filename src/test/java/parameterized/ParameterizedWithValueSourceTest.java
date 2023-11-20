package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedWithValueSourceTest {
	
	WordCounter wordCounter = new WordCounter();

	@ParameterizedTest
	@ValueSource(strings = {"check three parameters", 
			"junit in action"})
	void testWordsInSentence(String sentence) {
		assertEquals(3, wordCounter.countWords(sentence));
	}
}
