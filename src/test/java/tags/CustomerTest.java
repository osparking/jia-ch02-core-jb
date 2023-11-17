package tags;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("individual")
class CustomerTest {

	@Test
	@DisplayName("고객 객체에 이름이 바르게 저장됨")
	void testCustomerName() {
		String name = "철수";
		Customer customer = new Customer(name);
		assertEquals(name, customer.getName());
	}
}
