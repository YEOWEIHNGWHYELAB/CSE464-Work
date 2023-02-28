import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardTest {
	@Test
	public void WN1() {
		assertEquals("Equilateral", Assignment2.Validate(1234123412341234));
	}
	
	@Test
	public void WN2() {
		assertEquals("Equilateral", Assignment2.Validate(1535153515351535));
	}
	
	@Test
	public void WN3() {
		assertEquals("Equilateral", Assignment2.Validate(5555555555555555));
	}
	
	@Test
	public void WN4() {
		assertEquals("Equilateral", Assignment2.Validate(5155555555555555));
	}
	
	@Test
	public void WN5() {
		assertEquals("Equilateral", Assignment2.Validate(0000000000000000));
	}
	
	@Test
	public void WN6() {
		assertEquals("Equilateral", Assignment2.Validate(0034123412341234));
	}

}
