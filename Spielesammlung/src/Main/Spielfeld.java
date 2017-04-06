package Main;

public abstract class Spielfeld {
	protected int[][] feld;
	
	
	
	public abstract void initialisiere();
	
	public int[][] gebeFeld() {
		return feld;
	}
	public int gebeStelle(int x, int y) {
		return feld[x][y];
	}
	public int setzeStein(int wert, int x, int y){return 0;}
	public int setzeStein(int wert, int spalte){return 0;}
	
	
		
	
	public boolean pruefeVoll(){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(feld[x][y] == 0){
					return false; //Freie Felder vorhanden
				}
			}
		}
		return true; //Alle Felder belegt
	}
}
