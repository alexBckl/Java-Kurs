
public class Spielsteuerung {
	//Attribute
	private Oberflaeche dieOberflaeche;
	private Spieler derSpieler[];
	private int aktSpieler;
	private int status;
	
	//Operationen
	public Spielsteuerung() {
		dieOberflaeche = new Oberflaeche();
		derSpieler = new Spieler[2];
		derSpieler[0] = new Spieler(dieOberflaeche.leseText("Name Spieler 1: "));
		derSpieler[1] = new Spieler(dieOberflaeche.leseText("Name Spieler 2: "));
		status = 0;
	}
	
	public void spiele() {
		switch (status) {
		case 0:			//Spiel läuft
			break;
		case 1: 		//Spieler 1 gewinnt
			break;
		case 2:			//Spieler 2 gewinnt
			break;
		case 3:			//Nochmals spielen?
			break;
		}
	}
	
	private void erwarteEingabe() {
		
	}
	
	private void pruefeGewonnen() {
		
	}
}
