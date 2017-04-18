import java.util.Random;
public class Spielsteuerung {
	//Attribute
	private Oberflaeche dieOberflaeche;
	private Spieler derSpieler[];
	private int status;
	private int zug1;
	private int zug2;
	private int runden1;
	private int runden2;
	private Random zufall;
	
	//Operationen
	public Spielsteuerung() {
		dieOberflaeche = new Oberflaeche();
		derSpieler = new Spieler[2];
		
		dieOberflaeche.gebeAus("***********************", true);
		dieOberflaeche.gebeAus("* Schere Stein Papier *", true);
		dieOberflaeche.gebeAus("***********************", true);
		dieOberflaeche.gebeAus("", true);	
		
		String eingabe;
		do{
			eingabe = dieOberflaeche.leseText("Gegen Computer spielen? ");
		}
		while(!eingabe.toLowerCase().equals("j") && !eingabe.toLowerCase().equals("n"));
		
		dieOberflaeche.gebeAus("", true);
		dieOberflaeche.gebeAus("Bitte Namen eingeben:", true);
		derSpieler[0] = new Spieler(dieOberflaeche.leseText("Spieler 1: "));
		
		if(eingabe.equals("n")){		
			
			derSpieler[1] = new Spieler(dieOberflaeche.leseText("Spieler 2: "));
			status = 0;
		}
		
		else{
			derSpieler[1] = new Spieler("Computer");
			zufall = new Random();
			status = 4;
		}
		
	}
	
	public void spiele() {
		switch (status) {
		case 0:			//Spiel läuft
			erwarteEingabe();
			pruefeGewonnen();
			break;
		case 1: 		//Spieler 1 gewinnt
			dieOberflaeche.gebeAus("", true);
			dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " gewinnt das Spiel!", true);
			derSpieler[0].erhoehePunkte();
			status = 3;
			break;
		case 2:			//Spieler 2 gewinnt
			dieOberflaeche.gebeAus("", true);
			dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " gewinnt das Spiel!", true);
			derSpieler[1].erhoehePunkte();
			status = 3;
			break;
		case 3:			//Nochmals spielen?
			dieOberflaeche.gebeAus("", true);
			dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " hat " + derSpieler[0].gebePunkte() + " Punkte.", true);
			dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " hat " + derSpieler[1].gebePunkte() + " Punkte.", true);
			dieOberflaeche.gebeAus("", true);
			String eingabe;
			
			do{
				eingabe = dieOberflaeche.leseText("Nochmals spielen? ");
			}
			while(!eingabe.equals("j") && !eingabe.equals("n"));
			
			if(eingabe.equals("n"))
				System.exit(0);
			
			else{
				if(derSpieler[1].gebeName().equals("Computer"))
					status = 4;
				else
					status = 0;
				
				runden1 = 0;
				runden2 = 0;
			}
			break;
		case 4:
			erwarteEingabePC();
			pruefeGewonnen();
			
		}
	}
	
	private void erwarteEingabe() {
		dieOberflaeche.gebeAus("", true);
		
		dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " ist am Zug: ", true);
		do{
			dieOberflaeche.gebeAus("************************************", true);
			dieOberflaeche.gebeAus("* 1: Schere * 2: Stein * 3: Papier *", true);
			dieOberflaeche.gebeAus("************************************", true);
			zug1 = dieOberflaeche.leseZahl("Eingabe: ");
		}
		
		while(zug1 < 1 || zug1 > 3);
		
		for(int x = 0; x < 20; x++)
			dieOberflaeche.gebeAus("", true);
		
		dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " ist am Zug: ", true);
		do{
			dieOberflaeche.gebeAus("************************************", true);
			dieOberflaeche.gebeAus("* 1: Schere * 2: Stein * 3: Papier *", true);
			dieOberflaeche.gebeAus("************************************", true);
			zug2 = dieOberflaeche.leseZahl("Eingabe: ");
		}
		
		while(zug2 < 1 || zug2 > 3);	
	}
	
	private void erwarteEingabePC() {
		dieOberflaeche.gebeAus("", true);
		
		dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " ist am Zug: ", true);
		do{
			dieOberflaeche.gebeAus("************************************", true);
			dieOberflaeche.gebeAus("* 1: Schere * 2: Stein * 3: Papier *", true);
			dieOberflaeche.gebeAus("************************************", true);
			zug1 = dieOberflaeche.leseZahl("Eingabe: ");
		}
		while(zug1 < 1 || zug1 > 3);
		
		dieOberflaeche.gebeAus("", true);
		dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " ist am Zug: ", true);
		do{
			dieOberflaeche.gebeAus("************************************", true);
			dieOberflaeche.gebeAus("* 1: Schere * 2: Stein * 3: Papier *", true);
			dieOberflaeche.gebeAus("************************************", true);
			zug2 = zufall.nextInt(3) + 1;
			dieOberflaeche.gebeAus("Eingabe " + zug2, true);
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
			if(zug2 == 3) {			//Spieler 1 gewinnt Runde
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " gewinnt die Runde!", true);
				runden1++;
			}
			else if(zug2 == 2) {	//Spieler 2 gewinnt Runde
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " gewinnt die Runde!", true);
				runden2++;
			}
			else {					//Unententschieden
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus("Keiner gewinnt die Runde!", true);
			}
			break;
		case 2: //Stein
			if(zug2 == 1) {			//Spieler 1 gewinnt Runde 
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " gewinnt die Runde!", true);
				runden1++;
			}
			else if(zug2 == 3) {	//Spieler 2 gewinnt Runde
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " gewinnt die Runde!", true);
				runden2++;
			}
			else {					//Unententschieden
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus("Keiner gewinnt die Runde!", true);
			}
			break;
		case 3: //Papier
			if(zug2 == 2) {			//Spieler 1 gewinnt Runde
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " gewinnt die Runde!", true);
				runden1++;
			}
			else if(zug2 == 1) {	//Spieler 2 gewinnt Runde
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " gewinnt die Runde!", true);
				runden2++;
			}
			else {					//Unententschieden
				dieOberflaeche.gebeAus("", true);
				dieOberflaeche.gebeAus("Keiner gewinnt die Runde!", true);
			}
			break;
		}
		
		if(runden1 >= 2)
			status = 1;
		else if(runden2 >= 2)
			status = 2;
	}
}
