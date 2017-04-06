package Main;

public abstract class Spielfeld {
	//Attribute
	protected int[][] feld;
	
	//Operationen
	public abstract void initialisiere();
	
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
