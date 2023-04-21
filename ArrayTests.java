import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}

  @Test
  public void testReverseInPlace1() {
    int[] input2 = {2, 4, 6};
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[]{6, 4, 2}, input2);
  }

  @Test
  public void testReverseInPlace2() {
    int[] input3 = {4, 12};
    ArrayExamples.reverseInPlace(input3);
    assertArrayEquals(new int[]{12, 4}, input3);
  }


  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testReversed1() {
    int[] input2 = { 1, 2, 3};
    assertArrayEquals(new int[]{ 3, 2, 1}, ArrayExamples.reversed(input2));
  }

  @Test
  public void testAverageWithoutLowest() {
    double[] inputList = {1.0, 1.0, 9.0, 3.0, 1.0, 1.0};
    assertEquals(6.0, ArrayExamples.averageWithoutLowest(inputList), 0.001);
  }
}
