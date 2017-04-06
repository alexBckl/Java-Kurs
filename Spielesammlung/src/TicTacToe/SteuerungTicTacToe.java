package TicTacToe;
import Main.Oberflaeche;
import Main.Spieler;

public class SteuerungTicTacToe extends Main.Spielsteuerung {
		
	//Konstruktor
	public SteuerungTicTacToe (Oberflaeche dieOberflaeche) {
		//Instanziierung der Objekte Oberflaeche und Spieler...
		super.dieOberflaeche = dieOberflaeche;
		super.dasSpielfeld = new FeldTicTacToe();
		super.derSpieler = new Spieler[2];
		
		//... mit gleichzeitiger Eingabe der Namen
		dieOberflaeche.gebeAus("TicTacToe", true);
		dieOberflaeche.gebeAus("Spieler 1: ", false);
		
		super.derSpieler[0] = new Spieler(dieOberflaeche.leseText(), 1, 'X');
		dieOberflaeche.gebeAus("Spieler 2: ", false);
		super.derSpieler[1] = new Spieler(dieOberflaeche.leseText(), -1, 'O');
		
		//Status auf 0, damit "Spiel läuft" in spiele() ausgeführt wird
		status = 0;
		//AktSpieler auf 0, damit das Spiel mit Spieler 1 beginnt
		aktSpieler = 0;
	}
	
	//Operationen
	protected void erwarteEingabe()	{
		dieOberflaeche.gebeAus(derSpieler[aktSpieler].gebeName() + " ist am Zug! ", true);
		int rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), leseX(), leseY());	
		dieOberflaeche.gebeAus("", true);
		
		while(rueckgabe == 0 || rueckgabe == 1) {
			switch(rueckgabe) {
			case 0:		//Fehlerhafte Eingabe
				dieOberflaeche.gebeAus("Fehlerhafte Eingabe! Nur Werte zwischen 1 und 8!", true);
				gebeSpielfeld();
				rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), leseX(), leseY());
				break;
			case 1:		//Feld belegt
				dieOberflaeche.gebeAus("Feld bereits Belegt", true);
				gebeSpielfeld();
				rueckgabe = dasSpielfeld.setzeStein(derSpieler[aktSpieler].gebeWert(), leseX(), leseY());
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
	private int leseX() 			{
		dieOberflaeche.gebeAus("X: ", false);
		return dieOberflaeche.leseZahl() - 1;
	}
	private int leseY() 			{
		dieOberflaeche.gebeAus("Y: ", false);
		return dieOberflaeche.leseZahl() - 1;
	}
	private void pruefeGewonnen()	{
		int spalte = 0;
		int reihe = 0;
		int diagonale1 = 0;
		int diagonale2 = 0;
		int pruefsumme = 3 * derSpieler[aktSpieler].gebeWert();
		
		//Spalten prüfen
		for(int y = 0; y < 3; y ++){
			spalte = 0;
			reihe = 0;
			
			//Spalten und Reihen prüfen
			for(int x = 0; x < 3; x++) {
				spalte += dasSpielfeld.gebeStelle(x, y);
				reihe += dasSpielfeld.gebeStelle(y, x);
			}
			//Diagonale prüfen
			diagonale1 += dasSpielfeld.gebeStelle(y, y);
			diagonale2 += dasSpielfeld.gebeStelle(2 - y, y);
			
			if(spalte == pruefsumme || reihe == pruefsumme || diagonale1 == pruefsumme || diagonale2 == pruefsumme) {
				status = aktSpieler + 1;
				return;
			}
			
		}
		
		if(dasSpielfeld.pruefeVoll()) {
			status = 3;
		}		
	}
}
