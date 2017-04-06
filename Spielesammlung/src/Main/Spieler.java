package Main;

public class Spieler {
	//Attribute
	private String name;
	private char figur;
	private int wert;
	private int siege;
	
	//Konstruktor
	public Spieler(String name, int wert, char figur) {
		this.name = name;
		this.figur = figur;
		this.wert = wert;
	}
	
	//Operationen
	public String gebeName() {
		return this.name;
	}
	public char gebeFigur() {
		return this.figur;
	}
	public int gebeWert() {
		return wert;
	}
	public int gebeSiege() {
		return siege;
	}
	
	public void erhoeheSiege() {
		siege++;
	}
}
