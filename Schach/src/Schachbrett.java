
public class Schachbrett {
	private String[][] spielfeld = new String[8][8];
	
	
	public Schachbrett(){
		initialisiere();
	}
	
	public void initialisiere(){
		
		for(int i = 0; i < 8; i += 7){
			spielfeld[0][i]  = "Turm";
			spielfeld[1][i]  = "Springer";
			spielfeld[2][i]  = "Lauefer";
			spielfeld[3][i]  = "Koenigin";
			spielfeld[4][i]  = "Koenig";
			spielfeld[5][i]  = "Laufer";
			spielfeld[6][i]  = "Springer";
			spielfeld[7][i]  = "Turm";
		}
		
		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 8; j++) {
				spielfeld[j][i] = "";
			}
		}
		
		for(int i = 0; i < 8; i++){
			spielfeld[i][1] = "Bauer";
			spielfeld[i][6] = "Bauer";
		}
		
	}
	
	public void zeigeSpielfeld(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.printf("%-10s", spielfeld[j][i]);
			}
			System.out.println("\n");
			}
		}
}
