package nested;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {
	private Customer(Builder builder) {
		gender = builder.gender;
		lastName = builder.lastName;
		firstName = builder.firstName;
		middleName = builder.middleName;
		customerDate = builder.customerDate;
	}

	private Gender gender;
	private String lastName;
	private String firstName;
	
	private String middleName;
	private LocalDate customerDate;
	
	public static class Builder {
		private Gender gender;
		private String lastName;
		private String firstName;
		
		private String middleName;
		private LocalDate customerDate;
		
		public Builder(Gender gender, String lastName, String firstName) {
			this.gender = gender;
			this.lastName = lastName;
			this.firstName = firstName;
		}
		
		public Builder withMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}
		
		public Builder withCustomerDate(LocalDate customerDate) {
			this.customerDate = customerDate;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
	}
}
