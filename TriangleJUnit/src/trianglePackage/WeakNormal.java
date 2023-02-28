package trianglePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WeakNormal {

	@Test
	public void WN1() {
		assertEquals("Equilateral", Triangle.Triangle_Test(5, 5, 5));
	}
	@Test
	public void WN2() {
		assertEquals("Isosceles", Triangle.Triangle_Test(2, 2, 3));
	}
	
	@Test
	public void WN3() {
		assertEquals("Scalene", Triangle.Triangle_Test(3, 4, 5));
	}
	
	@Test
	public void WN4() {
		assertEquals("Not a triangle", Triangle.Triangle_Test(4, 1, 2));
	}

}
