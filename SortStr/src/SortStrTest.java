import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortStrTest {

	@Test
	public void Test1() {
		assertEquals("Not a triangle", SortStr.SortStr("abc"));
	}
	@Test
	public void Test2() {
		assertEquals("Not a triangle", SortStr.SortStr("iuimwq"));
	}
	
	@Test
	public void Test3() {
		assertEquals("Not a triangle", SortStr.SortStr("iiiiiiiiii"));
	}
	
	@Test
	public void Test4() {
		assertEquals("Not a triangle", SortStr.SortStr("abcdefg"));
	}

}
