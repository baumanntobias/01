import junit.framework.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class BruchTest {

	private Bruch bruchadd1 = new Bruch(1, 6);
	private Bruch bruchadd2 = new Bruch(2, 15);
	private Bruch bruchadd3 = new Bruch(1, 5);
	private Bruch bruchadd4 = new Bruch(2, 10);
	private Bruch bruchadd5 = new Bruch(3, 5);
	private Bruch bruchadd6 = new Bruch(1, 2, 3);
	private Bruch bruchadd7 = new Bruch(1, 3);
	private Bruch bruchadd8 = new Bruch(7, 3);
	private Bruch bruchadd9 = new Bruch(8, 6);
	private Bruch bruchadd10 = new Bruch(2, 8, 3);
	private Bruch bruchadd11 = new Bruch(1, 1, 3);

	@Test
	public void testAddiere() {
		Bruch result = new Bruch(3, 10);
		Bruch result2 = new Bruch(2, 5);
		Bruch result3 = new Bruch(4, 5);
		Bruch result4 = new Bruch(1, 5, 6);
		Bruch result5 = new Bruch(2, 2, 3);
		Bruch result6 = new Bruch(3, 1, 3);
		Bruch result7 = new Bruch(2, 8, 15);
		Bruch result8 = new Bruch(3, 2, 3);
		Bruch result9 = new Bruch(4, 5, 6);
		Bruch result10 = new Bruch(5);
		Bruch result11 = new Bruch(7);
		Bruch result12 = new Bruch(6, 1, 3);
		Bruch result13 = new Bruch(9, 1, 3);
		// echte + echte
		Assert.assertEquals("FEHLER", result, bruchadd1.addiere(bruchadd2));
		// echte + echte, mit gleichem Nenner
		Assert.assertEquals("FEHLER", result2, bruchadd3.addiere(bruchadd3));
		//
		Assert.assertEquals("FEHLER", result3, bruchadd4.addiere(bruchadd5));
		// echte + ganzeZahl und echte
		Assert.assertEquals("FEHLER", result4, bruchadd1.addiere(bruchadd6));
		// echte + unechte
		Assert.assertEquals("FEHLER", result5, bruchadd7.addiere(bruchadd8));
		// ganzeZahl echte + ganzeZahl echte (selbe bruch)
		Assert.assertEquals("FEHLER", result6, bruchadd6.addiere(bruchadd6));
		// ganzeZahl echte + ganzeZahl echte (verschiedene br�che)
		Assert.assertEquals("FEHLER", result8, bruchadd8.addiere(bruchadd9));
		// ganzeZahl unechter + echte (verschiedene nenner)
		Assert.assertEquals("FEHLER", result9, bruchadd1.addiere(bruchadd10));
		// ganzeZahl unechter + echte (gleiche nenner)
		Assert.assertEquals("FEHLER", result10, bruchadd7.addiere(bruchadd10));
		// //ganzeZahl unechter + unecht
		Assert.assertEquals("FEHLER", result11, bruchadd8.addiere(bruchadd10));
		// ganzeZahl unechter + ganzeZahl echte
		Assert.assertEquals("FEHLER", result12, bruchadd6.addiere(bruchadd10));
		// ganzeZahl unechter + ganzeZahl unechter (gleicher Bruch)
		Assert.assertEquals("FEHLER", result13, bruchadd10.addiere(bruchadd10));
	}

	@Test
	public void testGetDezimalzahl() {
		double result = 0.33;
		double result2 = 1.33;
		double result3 = 2.33;
		double result4 = 4.67;

		// Dezimalzahl mit echtem Bruch
		Assert.assertEquals("FEHLER", result, bruchadd7.getDezimalzahl());
		// Dezimalzahl mit ganzer Zahl und echtem Bruch
		Assert.assertEquals("FEHLER", result2, bruchadd11.getDezimalzahl());
		// Dezimalzahl mit unechtem Bruch
		Assert.assertEquals("FEHLER", result3, bruchadd8.getDezimalzahl());
		// Dezimalzahl mit ganzer Zahl und unechtem Bruch
		Assert.assertEquals("FEHLER", result4, bruchadd10.getDezimalzahl());
	}

	@Test
	public void testUnechterBruch() {
		Bruch result = new Bruch(4,3);
		
		//echte Bruch mit ganzer Zahl in unechten umwandeln
		Assert.assertEquals("FEHLER",result,bruchadd11.unechterBruch());
	}

	@Test
	public void testEchterBruch() {
		Bruch result = new Bruch (2,1,3);
		Bruch result2 = new Bruch (4,2,3);
		//unechter Bruch in echten umwandeln mit ganzer Zahl
		Assert.assertEquals("FEHLER",result,bruchadd8.echterBruch());
		
		//ganze Zahl und unechten Bruch in echten Bruch umwandeln
		Assert.assertEquals("FEHLER",result2,bruchadd10.echterBruch());
	}

	@Test
	public void testSubtrahiere() {
		Bruch result = new Bruch(1,30);
		Bruch result2 = new Bruch(0);
		Bruch result3 = new Bruch(-1,1,2);
		// echte + echte
		Assert.assertEquals("FEHLER", result, bruchadd1.subtrahiere(bruchadd2));
		// echte + echte, mit gleichem Nenner
		Assert.assertEquals("FEHLER", result2, bruchadd3.subtrahiere(bruchadd3));
//		//
//		Assert.assertEquals("FEHLER", result3, bruchadd4.addiere(bruchadd5));
		// echte + ganzeZahl und echte
//		Assert.assertEquals("FEHLER", result3, bruchadd1.subtrahiere(bruchadd6));
//		// echte + unechte
//		Assert.assertEquals("FEHLER", result5, bruchadd7.addiere(bruchadd8));
//		// ganzeZahl echte + ganzeZahl echte (selbe bruch)
//		Assert.assertEquals("FEHLER", result6, bruchadd6.addiere(bruchadd6));
//		// ganzeZahl echte + ganzeZahl echte (verschiedene br�che)
//		Assert.assertEquals("FEHLER", result8, bruchadd8.addiere(bruchadd9));
//		// ganzeZahl unechter + echte (verschiedene nenner)
//		Assert.assertEquals("FEHLER", result9, bruchadd1.addiere(bruchadd10));
//		// ganzeZahl unechter + echte (gleiche nenner)
//		Assert.assertEquals("FEHLER", result10, bruchadd7.addiere(bruchadd10));
//		// //ganzeZahl unechter + unecht
//		Assert.assertEquals("FEHLER", result11, bruchadd8.addiere(bruchadd10));
//		// ganzeZahl unechter + ganzeZahl echte
//		Assert.assertEquals("FEHLER", result12, bruchadd6.addiere(bruchadd10));
//		// ganzeZahl unechter + ganzeZahl unechter (gleicher Bruch)
//		Assert.assertEquals("FEHLER", result13, bruchadd10.addiere(bruchadd10));
		
	}

	@Test
	public void testMultipliziere() {
		Bruch result = new Bruch(1,45);
		Bruch result2 = new Bruch(1,25);
		Bruch result4 = new Bruch(1,9);
		Bruch result5 = new Bruch(7,9);
		Bruch result6 = new Bruch(4,9);
		Bruch result8 = new Bruch(3,1,9);
		
		// echte + echte
		Assert.assertEquals("FEHLER", result, bruchadd1.multipliziere(bruchadd2));
		// echte + echte, mit gleichem Nenner
		Assert.assertEquals("FEHLER", result2, bruchadd3.multipliziere(bruchadd3));
//		//
//		Assert.assertEquals("FEHLER", result3, bruchadd4.addiere(bruchadd5));
		// echte + ganzeZahl und echte
		Assert.assertEquals("FEHLER", result4, bruchadd1.multipliziere(bruchadd6));
		// echte + unechte
		Assert.assertEquals("FEHLER", result5, bruchadd7.multipliziere(bruchadd8));
		// ganzeZahl echte + ganzeZahl echte (selbe bruch)
		Assert.assertEquals("FEHLER", result6, bruchadd6.multipliziere(bruchadd6));
		// ganzeZahl echte + ganzeZahl echte (verschiedene br�che)
		Assert.assertEquals("FEHLER", result8, bruchadd8.multipliziere(bruchadd9));
//		// ganzeZahl unechter + echte (verschiedene nenner)
//		Assert.assertEquals("FEHLER", result9, bruchadd1.addiere(bruchadd10));
//		// ganzeZahl unechter + echte (gleiche nenner)
//		Assert.assertEquals("FEHLER", result10, bruchadd7.addiere(bruchadd10));
//		// //ganzeZahl unechter + unecht
//		Assert.assertEquals("FEHLER", result11, bruchadd8.addiere(bruchadd10));
//		// ganzeZahl unechter + ganzeZahl echte
//		Assert.assertEquals("FEHLER", result12, bruchadd6.addiere(bruchadd10));
//		// ganzeZahl unechter + ganzeZahl unechter (gleicher Bruch)
//		Assert.assertEquals("FEHLER", result13, bruchadd10.addiere(bruchadd10));
//		
	}

	@Test
	public void testDividieren() {
		// fail("Not yet implemented");
	}

	@Test
	public void testPotenzieren() {
		Bruch result1 = new Bruch(1, 1);
		Bruch result2 = new Bruch(2, 3);
		Bruch result3 = new Bruch(4, 9);
		Bruch result4 = new Bruch(8, 27);
		
		Bruch bruchadd = new Bruch(2, 3);
		Assert.assertEquals("Fehler", result1.toString(), bruchadd.potenzieren(0).toString());
		Assert.assertEquals("Fehler", result2.toString(), bruchadd.potenzieren(1).toString());
		Assert.assertEquals("Fehler", result3.toString(), bruchadd.potenzieren(2).toString());
		Assert.assertEquals("Fehler", result4.toString(), bruchadd.potenzieren(3).toString());
		// fail("Not yet implemented");
	}

}
