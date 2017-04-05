
public class Main {

	public static void main(String[] args) {
		Oberflaeche dieOberflaeche = new Oberflaeche();
		Spielsteuerung dieSpielsteuerung = new Spielsteuerung(dieOberflaeche);
	
		while(true) {
			dieSpielsteuerung.spiele();
		}
	}
	//Testkommentar
}
