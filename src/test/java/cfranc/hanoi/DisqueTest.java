package cfranc.hanoi;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class DisqueTest {
	Disque petit = new Disque(1);
	Disque moyen = new Disque(2);
	Disque grand = new Disque(3);
	
	@Test
	public void testCompareTo_SmallMedium_Negative() {
		int expected = -1;
		assertEquals(expected, petit.compareTo(moyen));
	}
	
	@Test
	public void testCompareTo_MediumTall_Negative() {
		int expected = -1;
		assertEquals(expected, moyen.compareTo(grand));
	}
	
	@Test
	public void testCompareTo_SmallTall_Negative() {
		int expected = -1;
		assertEquals(expected, petit.compareTo(grand));
	}
	
	@Test
	public void testCompareTo_MediumSmall_Positive() {
		int expected = 1;
		assertEquals(expected, moyen.compareTo(petit));
	}
	
	@Test
	public void testCompareTo_TallSmall_Positive() {
		int expected = 1;
		assertEquals(expected, grand.compareTo(petit));
	}
	
	@Test
	public void testCompareTo_TallMedium_Positive() {
		int expected = 1;
		assertEquals(expected, grand.compareTo(moyen));
	}
	
	@Test
	public void testCompareTo_TallTall_Zero() {
		int expected = 0;
		Disque grand2 = new Disque(3);
		assertEquals(expected, grand.compareTo(grand2));
	}
	
	@Test
	public void testCompareTo_MediumMedium_Zero() {
		int expected = 0;
		Disque moyen2 = new Disque(2);
		assertEquals(expected, moyen.compareTo(moyen2));
	}
	
	@Test
	public void testCompareTo_SmallSmall_Zero() {
		int expected = 0;
		Disque petit2 = new Disque(1);
		assertEquals(expected, petit.compareTo(petit2));
	}
}
