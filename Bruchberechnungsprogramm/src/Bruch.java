import java.text.*;
/**
 * Programm zur Erzeugung von Brüchen und zur Durchführung von Rechenoperationen
 * 
 * @author Patric Auer
 * @author Tobias Baumann
 * @author Roman Bucnev
 * @version 11.10.2013
 */

public class Bruch {

	// Deklaration der Attribute
	private long zaehler;
	private long nenner;
	private long ganzeZahl;
	
	
	/**
	 * Default Konstruktor
	 * 
	 */
	public Bruch() {
		this.zaehler = 0;
		this.nenner = 0;
	}

	/**
	 * Konstruktor zur Erzeugung eines Bruch aus einer ganzen Zahl
	 * 
	 * @param g
	 */
	public Bruch(long g) {
		this.zaehler = g;
		this.nenner = 1;
	}

	/**
	 * Konstruktor zur Erzeugung eines echten Bruch
	 * 
	 * @param z
	 * @param n
	 */
	public Bruch(long z, long n) {
		this.zaehler = z;
		this.nenner = n;
		if (n == 0){
			System.err.println("NICHT ZULÄSSIG!"); //EXCeption einbauen!
		}
	}

	/**
	 * Konstruktor zur Erzeugung eines echten Bruches mit ganzer Zahl
	 * 
	 * @param g
	 * @param z
	 * @param n
	 */
	public Bruch(long g, long z, long n) {
		this.zaehler = z;
		this.nenner = n;
		this.ganzeZahl = g;
		if (n == 0){
			System.err.println("NICHT ZULÄSSIG!"); //EXCeption einbauen!
		}
	}
	/**
	 * Methode zum erhalten von double Werten mit zwei Nachkommastellen
	 * @param d
	 * @return gerundeter double Wert
	 */
	public static double roundS (double d){
		return Math.rint(d*100)/100.;
	}

	/**
	 * Methode um Brüche zu addieren
	 * 
	 * @param zaehler
	 * @param nenner
	 * @param ganzeZahl
	 * @return addierter Bruch
	 */
	public Bruch addiere(Bruch bruch) {
		long zaehler = 0;
		long nenner = 0;
		long ganzeZahl = 0;

		if (this.nenner == bruch.nenner) {
			zaehler = this.zaehler + bruch.zaehler;
			nenner = this.nenner;
			ganzeZahl = this.ganzeZahl + bruch.ganzeZahl;

		} else {
			nenner = this.nenner * bruch.nenner;
			zaehler = (this.zaehler * bruch.nenner)
					+ (this.nenner * bruch.zaehler);
			ganzeZahl = this.ganzeZahl + bruch.ganzeZahl;
		}

		if (new Bruch(ganzeZahl, zaehler, nenner).isEcht()) {
			return new Bruch(ganzeZahl, zaehler, nenner).kuerzen(this);
		} else {
			return new Bruch(ganzeZahl, zaehler, nenner).echterBruch().kuerzen(
					this);
		}
	}

	/**
	 * Methode um Brüche zu subtrahieren
	 * 
	 * @param
	 * @return
	 */
	Bruch subtrahiere(Bruch bruch) {
		long zaehler = 0;
		long nenner = 0;
		if (this.nenner == bruch.nenner) {
			zaehler = this.zaehler - bruch.zaehler;
			nenner = this.nenner;
			ganzeZahl = this.ganzeZahl + bruch.ganzeZahl;
		} else {
			nenner = this.nenner * bruch.nenner;
			zaehler = (this.zaehler * bruch.nenner)
					- (this.nenner * bruch.zaehler);
			ganzeZahl = this.ganzeZahl + bruch.ganzeZahl;
		}
		
		if (new Bruch(ganzeZahl, zaehler, nenner).isEcht()) {
			return new Bruch(ganzeZahl, zaehler, nenner).kuerzen(this);
		} else {
			return new Bruch(ganzeZahl, zaehler, nenner).echterBruch().kuerzen(
					this);
		}
	}

	/**
	 * Methode um Brüche zu multiplizieren
	 * 
	 * @param
	 * @return
	 */
	Bruch multipliziere(Bruch bruch) {
		long zaehler = 0;
		long nenner = 0;
		long ganzeZahl = 0;

		zaehler = this.zaehler * bruch.zaehler;
		nenner = this.nenner * bruch.nenner;

		if (new Bruch(ganzeZahl, zaehler, nenner).isEcht()) {
			return new Bruch(ganzeZahl, zaehler, nenner).kuerzen(this);
		} else {
			return new Bruch(ganzeZahl, zaehler, nenner).echterBruch().kuerzen(
					this);
		}
	}

	/**
	 * Methode um den Kerhwert zu ermitteln. Zähler und Nenner werden vertauscht
	 * 
	 * @return Den Kehrwert des Bruchs. Nenner und Zähler wurden vertauscht.
	 */
	Bruch kehrwert() {
		long zaehler = 0;
		long nenner = 0;
		zaehler = this.nenner;
		nenner = this.zaehler;

		return new Bruch(zaehler, nenner);
	}

	public static long ggt(long zaehler, long nenner) {
		if (nenner != 0)
			return ggt(nenner, zaehler % nenner);
		else
			return zaehler;
	}

	/**
	 * Methode um Brüche zu kürzen
	 * 
	 * @param bruch
	 * @return Der Bruch der gekürzt wurde.
	 */
	Bruch kuerzen(Bruch bruch) {
		long ggt = ggt(this.zaehler, this.nenner);
		this.zaehler /= ggt;
		this.nenner /= ggt;
		return new Bruch(this.ganzeZahl, this.zaehler, this.nenner);
	}

	/**
	 * Methode zur Übrprüfung, ob der eingegeben Bruch ein echter Bruch ist
	 * 
	 * @return ganzeZahl, zähler und nenner
	 */
	Bruch echterBruch() {
		long zaehler = 0;
		long nenner = 0;
		long ganzeZahl = 0;

		if (this.zaehler > this.nenner) {
			ganzeZahl = this.ganzeZahl + (this.zaehler / this.nenner);
			zaehler = this.zaehler % this.nenner;
			nenner = this.nenner;
		}
		if (this.zaehler % this.nenner == 0) {
			return new Bruch(ganzeZahl);
		}

		return new Bruch(ganzeZahl, zaehler, nenner);
	}

	/**
	 * Methode zur Überprufung, ob der eingegeben Bruch ein unechter Bruch ist
	 * 
	 * @return zaehler und nenner
	 */
	Bruch unechterBruch() {
		long zaehler = 0;
		long nenner = 0;

		zaehler = ((this.ganzeZahl * this.nenner) + this.zaehler);
		nenner = this.nenner;

		return new Bruch(zaehler, nenner);
	}

	/**
	 * Methode um Brüche zu dividieren
	 * 
	 * @param bruch
	 * @return
	 */
	Bruch dividieren(Bruch bruch) {
		long zaehler = 0;
		long nenner = 0;
		zaehler = this.zaehler * bruch.nenner;
		nenner = this.nenner * bruch.zaehler;
		bruch.kuerzen(bruch);

		return new Bruch(zaehler, nenner).kuerzen(this);
	}

	/**
	 * Methode um Brüche zu potenzieren
	 * 
	 * @param potenz
	 * @return
	 */
	Bruch potenzieren(long potenz) {
		long zaehler = 0;
		long nenner = 0;

		zaehler = (long) (Math.pow(this.zaehler, potenz));
		nenner = (long) Math.pow(this.nenner, potenz);

		return new Bruch(zaehler, nenner).kuerzen(this);
	}

	protected boolean isEcht() {
		if (this.zaehler > this.nenner) {
			return false;
		}

		return true;
	}

	/**
	 * Methode um Brüche in Dezimalzahlen umzuwandeln
	 * 
	 * @return dezimalzahl
	 */
	protected double getDezimalzahl() {
		if(this.ganzeZahl == 0){
			return roundS((double)this.zaehler/this.nenner);	
		}else{
			return this.ganzeZahl + roundS((double)this.zaehler/this.nenner);
		}
		
		
		
	}

	protected long getGanzeZahl() {
		return ganzeZahl;
	}

	protected long getNenner() {
		return nenner;
	}

	protected long getZaehler() {
		return zaehler;
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != getClass())
			return false;

		Bruch bruch = (Bruch) other;
		if (this.ganzeZahl == bruch.ganzeZahl && this.zaehler == bruch.zaehler
				&& this.nenner == bruch.nenner) {
			return true;
		}

		return false;
	}

	public String toString() {
		if (this.nenner == 1) {
			return this.zaehler + "";
		} else if (this.ganzeZahl == 0) {
			return this.zaehler + "/" + this.nenner;
		} else {
			return this.ganzeZahl + " " + this.zaehler + "/" + this.nenner;
		}
	}
}
