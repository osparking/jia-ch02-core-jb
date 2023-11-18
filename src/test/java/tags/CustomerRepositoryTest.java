package tags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("repository")
class CustomerRepositoryTest {

	private String custName = "미자";
	private CustomerRepository repository = new CustomerRepository();
	
	@Test
	@DisplayName("없은 미자 정말 없음 검증")
	void testNonCustomer() {
		boolean isCustomer = repository.contains(custName);
		assertFalse(isCustomer);
	}
	
	@Test
	@DisplayName("저장한 미자 정말 저장됨 검증")
	void testCustomerStored() {
		repository.persist(new Customer(custName));
		assertTrue(repository.contains(custName));
	}
}
