package hamcrest;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {
	
	private static String LAST_NAME = "홍";
	private static String FIRST_NAME = "길동";
	private static Customer customer = new Customer(FIRST_NAME, LAST_NAME);
	
	@Test
	@DisplayName("널 예상됨")
	void testNull() {
		assertThat(null, nullValue());
	}

	@Test 
	@DisplayName("고객 객체 예상됨")
	void testObject() {
		assertThat(customer, notNullValue(Customer.class));
	}
	
	@Test
	@DisplayName("고객 성질속성이 바르다")
	void testCustomerProperties() {
		assertThat(customer, allOf(
					hasProperty("firstName", is(FIRST_NAME)),
					hasProperty("lastName", is(LAST_NAME))
				));
	}
	
	@Test
	@DisplayName("햄크레스트 is, anyOf, allOf")
	void testHamcrestIs() {
		int price1 = 1, price2 = 2, price3 = 2;
		assertThat(1, is(price1));
		assertThat(1, is(equalTo(price1)));
		assertThat(2, anyOf(is(price1), is(price2)));
		assertThat(2, allOf(is(price2), is(price3)));
	}
}
