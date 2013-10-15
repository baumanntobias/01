import static org.junit.Assert.*;

import org.junit.Test;

public class BruchTest {

	// Bruch bruch = new Bruch();

	// public void blaBruch() {
	// bruchadd2 = new Bruch(2, 15);
	// bruchadd3 = new Bruch(1, 5);
	// bruchadd4 = new Bruch(1, 5);
	// bruchadd5 = new Bruch(2, 10);
	// bruchadd6 = new Bruch(3, 5);
	// bruchadd7 = new Bruch
	// bruchadd8 = new Bruch
	// bruchadd9 = new Bruch
	// bruchadd10 = new Bruch
	// result1 = bruchadd1.addiere(bruchadd2);
	// result2 = bruchadd3.addiere(bruchadd4);
	// result3 = bruchadd5.addiere(bruchadd6);
	// }

	@Test
	public void testGetDezimalzahl() {
		// fail("Not yet implemented");
	}

	@Test
	public void testUnechterBruch() {
		// fail("Not yet implemented");
	}

	@Test
	public void testEchterBruch() {
		// fail("Not yet implemented");
	}

	@Test
	public void testAddiere() {
		assertEquals(new Bruch(3, 10).toString(),
				new Bruch(1, 6).addiere(new Bruch(2, 15)).toString());
		assertEquals(new Bruch(2, 5).toString(),
				new Bruch(1, 5).addiere(new Bruch(1, 5)).toString());
		assertEquals(new Bruch(8, 10).toString(),
				new Bruch(2, 10).addiere(new Bruch(3, 5)).toString());
	}

	@Test
	public void testSubtrahiere() {
		assertEquals(new Bruch(2, 15).toString(),
				new Bruch(3, 10).subtrahiere(new Bruch(1, 6)).toString());
		assertEquals(new Bruch(1, 5).toString(),
				new Bruch(2, 5).subtrahiere(new Bruch(1, 5)).toString());
		assertEquals(new Bruch(3, 5).toString(),
				new Bruch(8, 10).subtrahiere(new Bruch(2, 10)).toString());
	}

	@Test
	public void testMultipliziere() {
		// fail("Not yet implemented");
	}

	@Test
	public void testDividieren() {
		// fail("Not yet implemented");
	}

	@Test
	public void testPotenzieren() {
		// fail("Not yet implemented");
	}

	@Test
	public void testDivisonByZero() {

	}

}
