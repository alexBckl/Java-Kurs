package Main;

public abstract class Spielsteuerung {
		//Attribute
		protected int aktSpieler;
		protected int status;
		protected Oberflaeche dieOberflaeche;
		protected Spielfeld dasSpielfeld;
		protected Spieler[] derSpieler;
		
		//Konstruktor
		//public  Spielsteuerung(Oberflaeche dieOberflaeche){}
		
		//Operationen
		public void spiele()			{
			switch (status) {
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
				case 4:
				/*	System.out.print("Nochmal spielen?");
					String zeichen;
					do{
						zeichen = sc.next();
						System.out.println(zeichen);
					}
					while(!zeichen.toLowerCase().equals("j") 
							&& !zeichen.toLowerCase().equals("n"));

					if(zeichen.toLowerCase().equals("j")){
						System.out.println("Weiter");
						dasSpielfeld.initialisiere();
						status = 0;
					}
					else{
						System.out.println("Ende");
						System.exit(0);
					}*/
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
