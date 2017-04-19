
public class TernaryOperator {
	public void Uebung() {
		int x = 0;
		int y = 3;
		String text;
		
		//Ternärer Operator
		x = (y > 2) ? 5 : 0;
		text = (y > 2) ? "Wahr" : "Falsch";
		
		//Alternative Schreibweise, aber selbe Funktion
		if(y > 2) {
			text = "Wahr";
			x = 5;
		}
		else {
			text = "Falsch";
			x = 0;
		}
		
		
		System.out.println(x);
		System.out.println(text);
	}
}
