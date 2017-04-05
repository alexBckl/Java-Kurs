
public class Spielfeld {
	private int[][] feld = new int[3][3];
	private String[][] anzeige = new String[3][3];
	boolean unmoeglich = true;
	
	public Spielfeld(){
		initialisiere();
	}
	
	public void initialisiere(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				feld[i][j] = 0;
				anzeige[i][j] = " ";
			}
		}
	}
	
	public String[][] gebeFeld(){
		return anzeige;
	}
	
	public int[][] gebeWert(){
		return feld;
	}
	
	public void setzeFeld(int x, int y, int wert, String zeichen){
		feld[x][y] = wert;
		anzeige[x][y] = zeichen;
	}
	
	public boolean pruefeFeld(int x, int y){
		unmoeglich = (feld[x][y] != 0);
		return unmoeglich;
	}	
	
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
