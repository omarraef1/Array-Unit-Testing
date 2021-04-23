
/** 
 * This class has a few @Test methods for testing a 
 * few of the 15 required methods in ArrayFun.java.
 * This will require you to write all @Test methods for 
 * most of the functions specified in ArrayFun.java
 * 
 * @author Rick Mercer and Omar R. Gebril
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class ArrayFunTest {

  // If you include this variable, you can use myFun in all @Tests
  private ArrayFun myFun = new ArrayFun();

  @Test
  public void testNumberOfVowels() {
    char[] s = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    assertEquals(10, myFun.numberOfVowels(s));
    char[] t =  {'y', 'Y' };
    assertEquals(0, myFun.numberOfVowels(t));
    char[] u =  {'a', 'X', 'a' };
    assertEquals(2, myFun.numberOfVowels(u));
    char[] v =  { } ;
    assertEquals(0, myFun.numberOfVowels(v));
   
  }
             
  @Test
  public void testFailedNumberOfPairsWhenNone() {
    String[] s = { "a", "a", "a" };
    assertEquals(2, myFun.numberOfPairs(s));
    String[] t = {"a", "b", "c" };
    assertEquals(0, myFun.numberOfPairs(t));
    String[] u = {"a", "a", "b", "b" };
    assertEquals(2, myFun.numberOfPairs(u));
    String[] v = { };
    assertEquals(0, myFun.numberOfPairs(v));
    String[] w = { "a" };
    assertEquals(0, myFun.numberOfPairs(w));
  }
  
  @Test
  public void testSumGreaterThan() {
    double[] s = { 1.1, 2.2, 3.3 };
    assertTrue(myFun.sumGreaterThan(s,4.0));
    double[] t = { 1.1, 2.2, 3.3 };
    assertFalse(myFun.sumGreaterThan(t, 6.6));
    double[] u = {  };
    assertFalse(myFun.sumGreaterThan(u, -1.0));
  }

  // You will need to write your own @Test methods and assertions
  // for most of the 15 methods in ArrayFun

  @Test
  // KEEP THIS BECAUSE IT IS PROMISED IN THE SPEC
  public void testStats() {
    Scanner scanner = new Scanner("90.0 80.0 70.0 68.0");
    double[] result = myFun.stats(scanner);
    assertEquals(3, result.length); // The capacity is always 3
    assertEquals(90.0, result[0], 1e-12); // The maximum is at index 0
    assertEquals(68.0, result[1], 1e-12); // The minimum is at index 1
    assertEquals(77.0, result[2], 1e-12); // The average is at index 2
  }

  @Test
  // KEEP THIS BECAUSE IT IS PROMISED IN THE SPEC
  public void testFrequencyWithOneZeroTwoOnesTwoTwosTwoFiveAndNoThreesOrFours() {
    Scanner scanner = new Scanner("5 0 1 2 1 5 2");

    int[] result = myFun.frequency(scanner);
    assertEquals(11, result.length);

    assertEquals(1, result[0]); // There was 1 zero
    assertEquals(2, result[1]);
    assertEquals(2, result[2]);
    assertEquals(0, result[3]);
    assertEquals(0, result[4]);
    assertEquals(2, result[5]); // There were 2 5s
    for (int score = 6; score <= 10; score++)
      assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
  }


  @Test
  public void testHowMany() {
    String[] x = {"A", "a", "A", "a" };
    assertEquals(2, myFun.howMany(x, "A"));
    String[] y = {"And", "there", "goes", "another"};
    assertEquals(1, myFun.howMany(y,"another"));
    String[] z = {"And", "there", "goes", "another"};
    assertEquals(0, myFun.howMany(z, "Not Here"));
    String[] t = { };
    assertEquals(0, myFun.howMany(t, "empty array"));
  }
  
  @Test
  public void testSortOfSort2() {
    int[] x = { 4, 80, 3, 90, 2, 70, 1 };
    myFun.sortOfSort(x);
    assertEquals(1, x[0]);
    assertEquals(90, x[6]);
    assertEquals(159, x[1] + x[2] + x[3] + x[4] + x[5]);

    int[] y = { 4, 3, 2, 0, 1, 2 };
    myFun.sortOfSort(y);
    assertEquals(0, y[0]);
    assertEquals(4, y[5]);
    assertEquals(12, y[1] + y[2] + y[3] + y[4] + y[5]);

    int[] z = { 4, 3, 2, 1 };
    myFun.sortOfSort(z);
    assertEquals(1, z[0]);
    assertEquals(4, z[3]);
    assertEquals(9, z[1] + z[2] + z[3]);
    
    int[] t = { -1, 3, 2, 4 };
    myFun.sortOfSort(t);
    assertEquals(-1, t[0]);
    assertEquals(4, t[3]);
    assertEquals(9, t[1] + t[2] + t[3]);
    
    int[] v = { -1, 3, -1, 4 };
    myFun.sortOfSort(v);
    assertEquals(-1, v[0]);
    assertEquals(4, v[3]);
    assertEquals(6, v[1] + v[2] + v[3]);
  }

  @Test
  public void testEvensLeft() {
    int[] a = { 1, 2, 3, 4, 5, 6, 7 };
    myFun.evensLeft(a);

    // left side of the array at indexes 0..2 is even
    for (int i = 0; i <= 2; i++)
      assertEquals(0, a[i] % 2);

    // right side of the array at indexes 3..6 is odd
    for (int i = 3; i <= 6; i++)
      assertEquals(1, a[i] % 2);
  }
  
  @Test
  public void testShiftNTimes() {
    int[] x = { 1, 2, 3, 4, 5, 6, 7 };
    myFun.shiftNTimes(x, 1);
    assertEquals(2, x[0]);
    assertEquals(3, x[1]);
    int[] y = { 1, 2, 3, 4, 5, 6, 7 };
    myFun.shiftNTimes(y, 3);
    assertEquals(4, y[0]);
    assertEquals(5, y[1]);
    assertEquals(3, y[6]);
    int[] z = { 1, 2, 3 };
    myFun.shiftNTimes(z, 5);
    assertEquals(3, z[0]);
    assertEquals(1, z[1]);
    assertEquals(2, z[2]);
    int[] g = { 3 };
    myFun.shiftNTimes(g, 5);
    assertEquals(3, z[0]);
  }
  
  @Test
  public void testReplaced() {
    char[] x = {'A', 'B', 'C', 'D', 'B'};
    char[] a=myFun.replaced(x, 'B', '+');
    assertEquals('+', a[1]);
    assertEquals('+', a[4]);
    char[] y = { 'A', 'B', 'C', 'D', 'B'};
    char[] b=myFun.replaced(y, 'C', 'L' );
    assertEquals('L', b[2]);
    assertEquals('B', b[4]);
  }

  @Test
  public void testFailedRange5() {
    int[] x = { -1, 1, -2, 2, -3, 4, -4, 4 };
    assertEquals(8, myFun.range(x));
    int[] y = { -20, 1, -2, 2, -3, 4, -4, 9 };
    assertEquals(29, myFun.range(y));
    int[] z = { -20, -1, -2, -2, -3, -4, -4, -29 };
    assertEquals(28, myFun.range(z));
  }
  
  @Test
  public void testFound() {
	  String[] x = {"A","B","C"};
	  assertTrue(myFun.found("A", x));
	  assertFalse(myFun.found("Z", x));
  }
  
  @Test
  public void testSort() {
    String[] x = {"B", "C", "A"};
    myFun.sort(x);
    assertEquals("A", x[0]);
    assertEquals("C", x[2]);
    String[] y = {"g", "a", "X"};
    myFun.sort(y);
    assertEquals("X", y[0]);
    assertEquals("g", y[2]);
  }

  @Test
  public void fizzBuzz1() {
    String[] strs = myFun.fizzBuzz(1000, 1006);
    assertEquals(6, strs.length);
    assertEquals("Buzz", strs[0]);
    assertEquals("1001", strs[1]);
    assertEquals("Fizz", strs[2]);
    assertEquals("1003", strs[3]);
    assertEquals("1004", strs[4]);
    assertEquals("FizzBuzz", strs[5]);
  }



@Test
public void testmaxSpan() {
	int[] x = { 1, 2, 1, 1, 3 };
	int[] y = {5, 5, 6, 7, 2, 4, 5, 6};
	int[] z = { 1, 2, 1, 1, 3, 2,3,4,5,6,1,3,4,1,3,5,6,1,34,5,6};
	  assertEquals(4, myFun.maxSpan(x),1e-12);
	  assertEquals(7, myFun.maxSpan(y),1e-12);
	  assertEquals(18, myFun.maxSpan(z),1e-12);
	  }
}

