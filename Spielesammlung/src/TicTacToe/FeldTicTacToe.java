package TicTacToe;

public class FeldTicTacToe extends Main.Spielfeld{
	//Attribute
	boolean unmoeglich = true;
	
	//Konstruktor
	public FeldTicTacToe(){
		super.feld = new int[3][3];
		super.initialisiere();
	}
	
	//Operationen
	public int setzeStein(int wert, int x, int y)		{
		//Eingabe Pr�fen: Muss zwischen 1 und 8 liegen
		if(x < 0 || x > 2 || y < 0 || y > 2) 
			return 0;
		
		//Pr�fen, ob die gew�hlte Spalte nicht voll ist
		else if(!pruefeFeld(x, y)) {
			
			//Wenn noch nicht voll, dann Feld setzen
			feld[x][y] = wert;
			
			//Dann pr�fen, ob das Feld jetzt voll ist
			if(pruefeVoll())
				return 2;	//Wenn voll, dann 2 zur�ck geben
			else 
				return 3;	//Wenn nicht voll, dann 3 zur�ckgeben
		}
		
		//Letzer m�glicher Fall: Spalte ist voll
		else 
			return 1;		//Wenn Spalte voll ist, dann 1 zur�ckgeben
		
	}
	public int setzeStein(int wert, int spalte)			{
		return 0;
	}
	public boolean pruefeFeld(int x, int y)				{
		unmoeglich = (feld[x][y] != 0);
		return unmoeglich;
	}	
	public boolean pruefeVoll()							{
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
