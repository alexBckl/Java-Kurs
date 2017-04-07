package Main;

public abstract class Spielsteuerung {
		//Attribute
		protected int aktSpieler;
		protected int status;
		protected Oberflaeche dieOberflaeche;
		protected Spielfeld dasSpielfeld;
		protected Spieler[] derSpieler;
		
		//Operationen
		public void spiele()			{
			switch (status) {
				case 0: 	//Spiel läuft
					gebeSpielfeld();
					erwarteEingabe();
					break;
				case 1: 	//Spieler 1 gewinnt
					gebeSpielfeld();
					dieOberflaeche.gebeAus(derSpieler[0].gebeName() + " hat gewonnen!", true);
					status = 4;
					break;
				case 2: 	//Spieler 2 gewinnt
					gebeSpielfeld();
					dieOberflaeche.gebeAus(derSpieler[1].gebeName() + " hat gewonnen!", true);
					status = 4;
					break;
				case 3:		//Unentschieden
					gebeSpielfeld();
					dieOberflaeche.gebeAus("Unentschieden!", true);
					status = 4;
					break;
				case 4:		//Fragen, ob nochmal gespielt wird
					dieOberflaeche.gebeAus("Nochmal spielen? J für ja, N für nein", true);
					String zeichen;
					do{
						zeichen = dieOberflaeche.leseText();
					}
					while(!zeichen.toLowerCase().equals("j") 
							&& !zeichen.toLowerCase().equals("n"));

					if(zeichen.toLowerCase().equals("j")){
						dieOberflaeche.gebeAus("Nochmal!", true);
						dasSpielfeld.initialisiere();
						status = 0;
					}
					else{
						dieOberflaeche.gebeAus("Ende!", true);
						System.exit(0);
					}
					break;
				default:
					break;
			}
			
		}
		
		//Ausgabe des Spielfelds
		protected void gebeSpielfeld() 	{
			dieOberflaeche.gebeAus(dasSpielfeld.gebeFeld(), derSpieler[0].gebeFigur(), 
					derSpieler[1].gebeFigur());
		}
		
		//Annahme der Eingabe (Abstrakt!)
		protected abstract void erwarteEingabe();
}
