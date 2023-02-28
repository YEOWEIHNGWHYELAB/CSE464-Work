package trianglePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WeakRobust {

	@Test
	public void WN1() {
		assertEquals("Equilateral", Triangle.Triangle_Test(5, 5, 5));
	}
	
	@Test
	public void WN2() {
		assertEquals("Scalene", Triangle.Triangle_Test(3, 4, 5));
	}
	
	@Test
	public void WN3() {
		assertEquals("Isosceles", Triangle.Triangle_Test(2, 2, 3));
	}

	@Test
	public void WN4() {
		assertEquals("Not a triangle", Triangle.Triangle_Test(4, 1, 2));
	}

	@Test
	public void WR1() {
		assertEquals ("Value of a is out of range", Triangle.Triangle_Test(-2, 5, 5));
	}
	
	@Test
	public void WR2() {
		assertEquals ("Value of a is out of range", Triangle.Triangle_Test(201, 5, 5));
	}
	
	@Test
	public void WR3() {
		assertEquals ("Value of b is out of range", Triangle.Triangle_Test(5, -2, 5));
	}
	
	@Test
	public void WR4() {
		assertEquals ("Value of b is out of range", Triangle.Triangle_Test(5, 201, 5));
	}
	
	@Test
	public void WR5() {
		assertEquals ("Value of c is out of range", Triangle.Triangle_Test(5, 5, -2));
	}

	@Test
	public void WR6() {
		assertEquals ("Value of c is out of range", Triangle.Triangle_Test(5, 5, 201));
	}

}
