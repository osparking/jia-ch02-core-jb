package hamcrest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestListTest {
	private List<String> values;
	
	@BeforeEach
	public void setUp() {
		values = Arrays.asList("민호", "지수", "영철");
	}
	
	@Test
	@DisplayName("햄크레스트 비 사용 목록")
	public void testWOhamcrest() {
		assertEquals(3, values.size());
		assertTrue(values.contains("온달") 
				|| values.contains("준석") 
				|| values.contains("한호"));
	}
}
