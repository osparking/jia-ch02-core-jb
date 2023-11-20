package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ParameterizedWithEnumSourceTest {
  private WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @EnumSource(Sentences.class)
  void testWordsInSentence(Sentences sentence) {
      assertEquals(3, wordCounter.countWords(sentence.value()));
  }	

  enum Sentences {
      JUNIT_IN_ACTION("JUnit in Action"),
      SOME_PARAMETERS("Check some parameters"),
      THREE_PARAMETERS("Check three parameters");

      private final String sentence;

      Sentences(String sentence) {
          this.sentence = sentence;
      }

      public String value() {
          return sentence;
      }
  }
}
