package dynamic;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import predicate.PositiveNumberPredicate;

public class DynamicTestTest {
	private PositiveNumberPredicate predicate = new PositiveNumberPredicate();

	@TestFactory
	Iterator<DynamicTest> positiveNumberPredicateTestCases() {
		// @formatter:off
		return asList(
					dynamicTest("negative number",
							() -> assertFalse(predicate.check(-1))),
					dynamicTest("ZERO",
							() -> assertFalse(predicate.check(0))),
					dynamicTest("POSITIVE NUMBER",
							() -> assertTrue(predicate.check(1)))
				).iterator();
		// @formatter:on
	}

	@BeforeAll
	static void setUpClass() {
		System.out.println("before all");
	}

	@AfterAll
	static void closeClass() {
		System.out.println("after all");
	}

	@BeforeEach
	void setUpTest() {
		System.out.println("before each");
	}

	@AfterEach
	void closeTest() {
		System.out.println("after each");
	}
}
