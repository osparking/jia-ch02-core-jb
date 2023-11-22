package hamcrest;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {
	
	@Test
	@DisplayName("햄크레스트 is, anyOf, allOf")
	void testHamcrestIs() {
		int price1 = 1, price2 = 2, price3 = 2;
		assertThat(1, is(price1));
		assertThat(2, anyOf(is(price1), is(price2)));
		assertThat(2, allOf(is(price2), is(price3)));
	}
}
