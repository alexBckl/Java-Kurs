
public class Spielsteuerung {
	//Attribute
	private Oberflaeche dieOberflaeche;
	private Spieler derSpieler[];
	private int aktSpieler;
	private int status;
	private int zug1;
	private int zug2;
	private int runden1;
	private int runden2;
	
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
			erwarteEingabe();
			pruefeGewonnen();
			break;
		case 1: 		//Spieler 1 gewinnt
			System.out.println(derSpieler[0].gebeName() + " gewinnt das Spiel!");
			derSpieler[0].erhoehePunkte();
			status = 3;
			break;
		case 2:			//Spieler 2 gewinnt
			System.out.println(derSpieler[1].gebeName() + " gewinnt das Spiel!");
			derSpieler[1].erhoehePunkte();
			status = 3;
			break;
		case 3:			//Nochmals spielen?
			dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " hat " + derSpieler[0].gebePunkte() + " Punkte.", true);
			dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " hat " + derSpieler[1].gebePunkte() + " Punkte.", true);
			
			String eingabe;
			
			do{
				eingabe = dieOberflaeche.leseText("Nochmals spielen? ");
			}
			while(!eingabe.equals("j") && !eingabe.equals("n"));
			
			if(eingabe.equals("n"))
				System.exit(0);
			
			else{
				status = 0;
				runden1 = 0;
				runden2 = 0;
			}
			break;
		}
	}
	
	private void erwarteEingabe() {
		dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " ist am Zug: ", true);
		do{
			zug1 = dieOberflaeche.leseZahl("1: Schere, 2: Stein, 3: Papier \n");
		}
		
		while(zug1 < 1 || zug1 > 3);
		
		dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " ist am Zug: ", true);
		do{
			zug2 = dieOberflaeche.leseZahl("1: Schere, 2: Stein, 3: Papier \n");
		}
		
		while(zug2 < 1 || zug2 > 3);	
	}
	
	private void pruefeGewonnen() {
		//Schere schlägt Papier
		//Stein schlägt Schere
		//Papier schlägt Stein
		//Unentschieden
		
		//Schere = 1
		//Stein  = 2
		//Papier = 3
		
		switch(zug1) {
		case 1: // Schere
			if(zug2 == 3) {			//Spieler 1 Gewinnt
				System.out.println(derSpieler[0].gebeName() + " gewinnt die Runde!");
				runden1++;
			}
			else if(zug2 == 2) {	//Spieler 2 Gewinnt
				System.out.println(derSpieler[1].gebeName() + " gewinnt die Runde!");
				runden2++;
			}
			else {					//Unententschieden
				System.out.println("Keiner gewinnt die Runde!");
			}
			break;
		case 2: //Stein
			if(zug2 == 1) {			//Spieler 1 Gewinnt
				System.out.println(derSpieler[0].gebeName() + " gewinnt die Runde!");
				runden1++;
			}
			else if(zug2 == 3) {	//Spieler 2 Gewinnt
				System.out.println(derSpieler[1].gebeName() + " gewinnt die Runde!");
				runden2++;
			}
			else {					//Unententschieden
				System.out.println("Keiner gewinnt die Runde!");
			}
			break;
		case 3: //Papier
			if(zug2 == 2) {			//Spieler 1 Gewinnt
				System.out.println(derSpieler[0].gebeName() + " gewinnt die Runde!");
				runden1++;
			}
			else if(zug2 == 1) {	//Spieler 2 Gewinnt
				System.out.println(derSpieler[1].gebeName() + " gewinnt die Runde!");
				runden2++;
			}
			else {					//Unententschieden
				System.out.println("Keiner gewinnt die Runde!");
			}
			break;
		}
		
		if(runden1 >= 2)
			status = 1;
		else if(runden2 >= 2)
			status = 2;
	}
}
