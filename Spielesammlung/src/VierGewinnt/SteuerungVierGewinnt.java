package VierGewinnt;
import Main.Oberflaeche;
import Main.Spieler;

public class SteuerungVierGewinnt extends Main.Spielsteuerung{
	//Konstruktor
	public SteuerungVierGewinnt(Oberflaeche dieOberflaeche) {
		//Instanziierung der Objekte Oberflaeche und Spieler...
		super.dieOberflaeche = dieOberflaeche;
		super.dasSpielfeld = new FeldVierGewinnt();
		super.derSpieler = new Spieler[2];
		
		//... mit gleichzeitiger Eingabe der Namen
		dieOberflaeche.gebeAus("4-Gewinnt", true);
		dieOberflaeche.gebeAus("Spieler 1: ", false);
		super.derSpieler[0] = new Spieler(super.dieOberflaeche.leseText(), 1, 'X');
		dieOberflaeche.gebeAus("Spieler 2: ", false);
		super.derSpieler[1] = new Spieler(super.dieOberflaeche.leseText(), -1, 'O');
		
		//Status auf 0, damit "Spiel läuft" in spiele() ausgeführt wird
		status = 0;
		//AktSpieler auf 0, damit das Spiel mit Spieler 1 beginnt
		aktSpieler = 0;
	}
	
	//Operationen
	
	//Überprüfung, ob jemand gewinnt
	private void pruefeGewonnen() {
		int pruefsumme = 4 * derSpieler[aktSpieler].gebeWert();
		int spalte = 0;
		int reihe = 0;
		int diagonale = 0;
		
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
		//Diagonale "/"
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 5; x++) {
				diagonale = 0;
				diagonale += 	dasSpielfeld.gebeStelle(x, y) + dasSpielfeld.gebeStelle(x+1, y+1) + 
								dasSpielfeld.gebeStelle(x+2, y+2) + dasSpielfeld.gebeStelle(x+3, y+3);
				
				if(diagonale == pruefsumme) {
					status = aktSpieler + 1;
					return;
				}
			}
		}
		
		//Diagonale "\"
		for(int y = 0; y < 5; y++) {
			for(int x = 7; x > 2; x--) {
				diagonale = 0;
				diagonale += 	dasSpielfeld.gebeStelle(x, y) + dasSpielfeld.gebeStelle(x-1, y+1) + 
								dasSpielfeld.gebeStelle(x-2, y+2) + dasSpielfeld.gebeStelle(x-3, y+3);
				
				if(diagonale == pruefsumme) {
					status = aktSpieler + 1;
					return;
				}
			}
		}
	}
	
	
	
	//Annahme der Spalte, in der der Spielstein gesetzt werden soll
	protected void erwarteEingabe() {
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