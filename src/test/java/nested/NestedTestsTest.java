package nested;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTestsTest {
	private static final String LAST_NAME = "정";
	private static final String FIRST_NAME = "지현";
	
	@Nested
	class BuilderTest {
		
		@Test
		@DisplayName("내부 클래스인 Builder 생성자 및 메소드 기능 시험")
		void customerBuilder() throws ParseException {
			LocalDate customerDate = LocalDate.of(2019, 4, 21);
			Customer customer = new Customer.Builder(
					Gender.FEMALE, LAST_NAME, FIRST_NAME)
					.withCustomerDate(customerDate)
					.build();
			
			assertAll(() -> {
				assertEquals(Gender.FEMALE, customer.getGender());
				assertEquals(LAST_NAME, customer.getLastName());
				assertEquals(FIRST_NAME, customer.getFirstName());
				assertEquals(customerDate, customer.getCustomerDate());
			});
					
		}
	}

}
