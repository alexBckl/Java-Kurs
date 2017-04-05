
public class Spielsteuerung {
	//Attribute
	private int aktSpieler;
	private int status;
	private Oberflaeche dieOberflaeche;
	private Spielfeld dasSpielfeld;
	private Spieler[] derSpieler;
	
	//Konstruktor
	public Spielsteuerung(Oberflaeche dieOberflaeche) {
		//Instanziierung der Objekte Oberflaeche und Spieler...
		this.dieOberflaeche = dieOberflaeche;
		this.dasSpielfeld = new Spielfeld();
		this.derSpieler = new Spieler[2];
		
		//... mit gleichzeitiger Eingabe der Namen
		dieOberflaeche.gebeAus("Spieler 1: ", false);
		this.derSpieler[0] = new Spieler(dieOberflaeche.leseText(), 1, 'X');
		dieOberflaeche.gebeAus("Spieler 2: ", false);
		this.derSpieler[1] = new Spieler(dieOberflaeche.leseText(), -1, 'O');
		
		//Status auf 0, damit "Spiel läuft" in spiele() ausgeführt wird
		status = 0;
		//AktSpieler auf 0, damit das Spiel mit Spieler 1 beginnt
		aktSpieler = 0;
	}
	
	//Operationen
	public void spiele() {
		switch(status) {
		case 0: 	//Spiel läuft
			gebeSpielfeld();
			erwarteEingabe();
			break;
		case 1: 	//Spieler 1 gewinnt
			break;
		case 2: 	//Spieler 2 gewinnt
			break;
		case 3:		//Unentschieden
			break;
		}
	}
	
	//Überprüfung, ob jemand gewinnt
	private void pruefeGewonnen() {}
	
	//Ausgabe des Spielfelds
	private void gebeSpielfeld() {
		dieOberflaeche.gebeAus(dasSpielfeld.gebeFeld(), derSpieler[0].gebeFigur(), 
				derSpieler[1].gebeFigur());
	}
	
	//Annahme der Spalte, in der der Spielstein gesetzt werden soll
	private void erwarteEingabe() {
		int rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), dieOberflaeche.leseZahl());	
		
		while(rueckgabe == 0 || rueckgabe == 1) {
			switch(rueckgabe) {
			case 0:		//Fehlerhafte Eingabe
				dieOberflaeche.gebeAus("Fehlerhafte Eingabe! Nur Werte zwischen 1 und 8!", true);
				gebeSpielfeld();
				rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), dieOberflaeche.leseZahl());
				break;
			case 1:		//Spalte bereits voll
				dieOberflaeche.gebeAus("Spalte bereits voll! Bitte andere auswählen!", true);
				gebeSpielfeld();
				rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), dieOberflaeche.leseZahl());
				break;
			default:
				break;
			}
		}
		
		switch(rueckgabe) {
		case 2:		//Zug erfolgreich und gesamtes Spielfeld voll
			pruefeGewonnen();
			dieOberflaeche.gebeAus("Feld voll!", true);
			aktSpieler = (aktSpieler == 1) ? 0 : 1;
			break;
		case 3:		//Zug erfolgreich und gesamtes Spielfeld nicht voll
			pruefeGewonnen();
			aktSpieler = (aktSpieler == 1) ? 0 : 1;
			break;
		}
	}
		
}