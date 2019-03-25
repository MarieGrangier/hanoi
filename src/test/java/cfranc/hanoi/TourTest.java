package cfranc.hanoi;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class TourTest {
	
	Disque petit = new Disque(1);
	Disque moyen = new Disque(2);
	Disque grand = new Disque(3);
	int hauteurMax = 3;

	Tour t = new Tour(hauteurMax);
	Tour t2 = new Tour(hauteurMax);
	Tour petiteT= new Tour(1);
	
	@Test
	public void empile_TourVide_True() {
		assertEquals(true, t.empiler(grand));
	}
	
	@Test
	public void empile_TourNonVide_True() {
		t.empiler(grand);
		assertEquals(true, t.empiler(petit));
	}
	
	@Test
	public void empile_TourNonVide_False() {
		t.empiler(petit);
		assertEquals(false, t.empiler(grand));
	}
	
	@Test
	public void empile_TourPleine_False() {
		petiteT.empiler(grand);
		assertEquals(false, petiteT.empiler(petit));
	}
	
	//tests de régression de code 
	@Test
	public void testDepiler() {
		t.empiler(grand);
		t.empiler(moyen);
		t2.empiler(grand);
		t2.empiler(moyen);
		t2.empiler(petit);
		t2.depiler();
		assertEquals(t.taille(), t2.taille());
	}

	@Test
	public void sommetPetit() {
		t.empiler(grand);
		t.empiler(moyen);
		t.empiler(petit);
		assertEquals(petit.d, t.sommet().d);
	}
	
	@Test
	public void sommetVide() {
		assertEquals(null, t.sommet());
	}
	
	@Test
	public void estVide_True() {
		assertEquals(true, t.estVide());
	}
	
	@Test
	public void estVide_False() {
		t.empiler(grand);
		assertEquals(false, t.estVide());
	}
	
	@Test
	public void estPleine_False() {
		t.empiler(grand);
		assertEquals(false, t.estPleine());
	}
	
	@Test
	public void estPleine_True() {
		t.empiler(grand);
		t.empiler(moyen);
		t.empiler(petit);
		assertEquals(true, t.estPleine());
	}
	
	@Test
	public void diam_Grand() {
		t.empiler(grand);
		assertEquals(3, t.diam());
	}
	
	@Test
	public void diam_Null() {
		assertEquals(Integer.MAX_VALUE, t.diam());
	}
}
