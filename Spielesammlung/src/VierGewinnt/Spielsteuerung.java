package VierGewinnt;

public class Spielsteuerung extends Main.Spielsteuerung{
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
			gebeSpielfeld();
			dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " hat gewonnen!", false);
			System.exit(0);
			break;
		case 2: 	//Spieler 2 gewinnt
			gebeSpielfeld();
			dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " hat gewonnen!", false);
			System.exit(0);
			break;
		case 3:		//Unentschieden
			break;
		}
	}
	
	//Überprüfung, ob jemand gewinnt
	private void pruefeGewonnen() {
		int pruefsumme = 4 * derSpieler[aktSpieler].gebeWert();
		int spalte = 0;
		int reihe = 0;
		int diagonale1 = 0;
		int diagonale2 = 0;
		
		//Spalten
		for(int x = 0; x < 8; x++) {
			spalte = 0;
			for(int y = 0; y < 8; y++) {
				if(y < 4) {
					spalte += dasSpielfeld.gebeStelle(x, y);
				}
				else {
					spalte += dasSpielfeld.gebeStelle(x, y);
					spalte -= dasSpielfeld.gebeStelle(x, y - 4);
				}
				if(spalte == pruefsumme) {
					break;
				}
			}
			if(spalte == pruefsumme) {
				status = aktSpieler + 1;
				break;
			}
		}
		
		//Reihen
		for(int y = 0; y < 8; y++) {
			reihe = 0;
			for(int x = 0; x < 8; x++) {
				if(x < 4) {
					reihe += dasSpielfeld.gebeStelle(x, y);
				}
				else {
					reihe += dasSpielfeld.gebeStelle(x, y);
					reihe -= dasSpielfeld.gebeStelle(x - 4, y);
				}
				if(reihe == pruefsumme) {
					break;
				}
			}
			if(reihe == pruefsumme) {
				status = aktSpieler + 1;
				break;
			}
		}
	}
	
	//Ausgabe des Spielfelds
	private void gebeSpielfeld() {
		dieOberflaeche.gebeAus(dasSpielfeld.gebeFeld(), derSpieler[0].gebeFigur(), 
				derSpieler[1].gebeFigur());
	}
	
	//Annahme der Spalte, in der der Spielstein gesetzt werden soll
	private void erwarteEingabe() {
		dieOberflaeche.gebeAus(derSpieler[aktSpieler].gebeName() + ": ", false);
		int rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), dieOberflaeche.leseZahl());	
		dieOberflaeche.gebeAus("", true);
		
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