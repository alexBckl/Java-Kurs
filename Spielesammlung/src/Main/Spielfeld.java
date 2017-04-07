package Main;

public abstract class Spielfeld {
	//Attribute
	protected int[][] feld;
	
	//Operationen
	public void initialisiere()								{
		for(int x = 0; x < feld.length; x++){
			for(int y = 0; y < feld.length; y++){
				this.feld[x][y] = 0;
			}
		}
	}
	public int[][] gebeFeld()								{
		return feld;
	}
	public int gebeStelle(int x, int y) 					{
		return feld[x][y];
	}
	
	public abstract int setzeStein(int wert, int x, int y);
	public abstract int setzeStein(int wert, int spalte);
	public abstract boolean pruefeVoll();
}
