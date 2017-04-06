package Main;
import TicTacToe.*;
import VierGewinnt.*;

public class Main {

	public static void main(String[] args) {
		Oberflaeche dieOberflaeche = new Oberflaeche();
		Spielsteuerung dieSpielsteuerung;
		
		dieOberflaeche.gebeAus("Welches Spiel möchten Sie starten?" , true);
		dieOberflaeche.gebeAus("1: TicTacToe          2: 4 Gewinnt", true);
		dieOberflaeche.gebeAus("Eingabe: ", false);
		
		int auswahl = dieOberflaeche.leseZahl();
		
		while(auswahl != 1 && auswahl != 0) {
			dieOberflaeche.gebeAus("Fehlerhafte Eingabe!", true);
			dieOberflaeche.gebeAus("Eingabe: ", false);
			auswahl = dieOberflaeche.leseZahl();
		}
		
		if(auswahl == 1) 
			dieSpielsteuerung = new SteuerungTicTacToe(dieOberflaeche);
		else
			dieSpielsteuerung = new SteuerungVierGewinnt(dieOberflaeche);
	
		while(true) {
			dieSpielsteuerung.spiele();
		}
	}

}
