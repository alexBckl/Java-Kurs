
public class Spielfeld {
	//Attribute
	private int[][] feld = new int[8][8];
	
	//Konstruktor
	public Spielfeld() {
		initialisiere();
	}
	
	//Operationen
	public void initialisiere() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				feld[x][y] = 0;
			}
		}
	}
	public int setzeStein(int wert, int spalte) {
		//Eingabe Prüfen: Muss zwischen 1 und 8 liegen
		if(spalte < 1 || spalte > 8) 
			return 0;
		
		//Prüfen, ob die gewählte Spalte nicht voll ist
		else if(!pruefeSpalte(spalte - 1)) {
			
			//Wenn noch nicht voll, dann Feld setzen
			setzeFeld(wert, spalte - 1);
			
			//Dann prüfen, ob das Feld jetzt voll ist
			if(pruefeVoll())
				return 2;	//Wenn voll, dann 2 zurück geben
			else 
				return 3;	//Wenn nicht voll, dann 3 zurückgeben
		}
		
		//Letzer möglicher Fall: Spalte ist voll
		else 
			return 1;		//Wenn Spalte voll ist, dann 1 zurückgeben
		
	}
	public int[][] gebeFeld() {
		return feld;
	}
	public int gebeStelle(int x, int y) {
		return feld[x][y];
	}
	
	private void setzeFeld(int wert, int spalte) {
		for(int y = 0; y <= 7; y++) {
			if(feld[spalte][y] == 0) {
				feld[spalte][y] = wert;
				break;
			}
		}
	}
	private boolean pruefeVoll() {
		for(int x = 0; x < 8; x++) {
			if(!pruefeSpalte(x))
				return false;
		}
		return true;
	}
	private boolean pruefeSpalte(int spalte) {
		if(feld[spalte][7] != 0)
			return true;
		else 
			return false;
	}
}
