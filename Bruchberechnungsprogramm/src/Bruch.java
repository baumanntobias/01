import java.text.*;

/**
 * Programm zur Erzeugung von Br�chen und zur Durchf�hrung von Rechenoperationen
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
	 *            die Zahl die vor dem Bruch steht
	 */
	public Bruch(long g) {
		this.zaehler = g;
		this.nenner = 1;
	}

	/**
	 * Konstruktor zur Erzeugung eines echten Bruch
	 * 
	 * @param z
	 *            die Zahl die oberhalb des Bruches steht
	 * @param n
	 *            die Zahl die unterhalb des Bruch steht
	 */
	public Bruch(long z, long n) {
		this.zaehler = z;
		this.nenner = n;
		if (n == 0) {
			System.err.println("NICHT ZUL�SSIG!"); // Exception einbauen!
		}
	}

	/**
	 * Konstruktor zur Erzeugung eines echten Bruches mit ganzer Zahl
	 * 
	 * @param g
	 *            die Zahl die vor dem Bruch steht
	 * @param z
	 *            die Zahl die oberhalb des Bruches steht
	 * @param n
	 *            die Zahl die unterhalb des Bruch steht
	 */
	public Bruch(long g, long z, long n) {
		this.zaehler = z;
		this.nenner = n;
		this.ganzeZahl = g;
		if (n == 0) {
			System.err.println("NICHT ZUL�SSIG!"); // EXCeption einbauen!
		}
	}

	/**
	 * Methode zum erhalten von double Werten mit zwei Nachkommastellen
	 * 
	 * @param d
	 * @return gerundeter double Wert
	 */
	public static double roundS(double d) {
		return Math.rint(d * 100) / 100.;
	}

	/**
	 * Methode um Br�che zu addieren
	 * 
	 * @param zaehler
	 *            die Zahl die oberhalb des Bruches steht
	 * @param nenner
	 *            die Zahl die unterhalb des Bruch steht
	 * @param ganzeZahl
	 *            die Zahl die vor dem Bruch steht
	 * @return Ergebnis der Addition
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
	 * Methode um Br�che zu subtrahieren
	 * 
	 * @param bruch
	 * @return Ergebnis der Subtraktion
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
	 * Methode um Br�che zu multiplizieren
	 * 
	 * @param bruch
	 * @return Ergebnis der Muliplikation
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
	 * Methode um den Kerhwert zu ermitteln.
	 * 
	 * @return Den Kehrwert des Bruchs. Z�hler und Nenner wurden vertauscht
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
	 * Methode um Br�che zu k�rzen
	 * 
	 * @param bruch
	 * @return Der Bruch der gek�rzt wurde.
	 */
	Bruch kuerzen(Bruch bruch) {
		long ggt = ggt(this.zaehler, this.nenner);
		this.zaehler /= ggt;
		this.nenner /= ggt;
		return new Bruch(this.ganzeZahl, this.zaehler, this.nenner);
	}

	/**
	 * Methode zur �brpr�fung, ob der eingegebene Bruch ein echter Bruch ist
	 * 
	 * @return echter Bruch (ganzeZahl, z�hler und nenner)
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
	 * Methode zur �berprufung, ob der eingegebene Bruch ein unechter Bruch ist
	 * 
	 * @return unechter Bruch (zaehler und nenner)
	 */
	Bruch unechterBruch() {
		long zaehler = 0;
		long nenner = 0;

		zaehler = ((this.ganzeZahl * this.nenner) + this.zaehler);
		nenner = this.nenner;

		return new Bruch(zaehler, nenner);
	}

	/**
	 * Methode um Br�che zu dividieren
	 * 
	 * @param bruch
	 * @return Ergebnis der Divisioon
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
	 * Methode um Br�che zu potenzieren
	 * 
	 * @param potenz
	 * @return Ergebnis der Potenzierung
	 */
	Bruch potenzieren(long potenz) {
		long zaehler = 0;
		long nenner = 0;

		zaehler = (long) (Math.pow(this.zaehler, potenz));
		nenner = (long) Math.pow(this.nenner, potenz);

		if (new Bruch(ganzeZahl, zaehler, nenner).isEcht()) {
			return new Bruch(ganzeZahl, zaehler, nenner).kuerzen(this);
		} else {
			return new Bruch(ganzeZahl, zaehler, nenner).echterBruch().kuerzen(
					this);
		}

	}

	/**
	 * Methode zur �berpr�fung, ob ein echter Bruch vorhanden ist
	 * 
	 * @return gibt einen Boolean Wert zur�ck, ob der Bruch echt oder unecht ist
	 */
	protected boolean isEcht() {
		if (this.zaehler > this.nenner) {
			return false;
		}

		return true;
	}

	/**
	 * Methode um Br�che in Dezimalzahlen umzuwandeln
	 * 
	 * @return liefert den Bruch als Dezimalzahl zur�ck
	 */
	protected double getDezimalzahl() {
		if (this.ganzeZahl == 0) {
			return roundS((double) this.zaehler / this.nenner);
		} else {
			return this.ganzeZahl + roundS((double) this.zaehler / this.nenner);
		}

	}
	
	/**
	 * 
	 * @return
	 */
	protected long getGanzeZahl() {
		return ganzeZahl;
	}
	
	/**
	 * 
	 * @return
	 */
	protected long getNenner() {
		return nenner;
	}
	
	/**
	 * 
	 * @return
	 */
	protected long getZaehler() {
		return zaehler;
	}

	/**
	 * 
	 */
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

	/**
	 * 
	 */
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
