
public class Logik {
	public void Uebung() {
		boolean x = false;
		boolean y = false;
		int a = 2;
		int b = 5;
		
		if(x ^ y) {
			System.out.println("Entweder X oder Y");
		}
		if(x && y) {
			System.out.println("X und Y");
		}
		if(x || y) {
			System.out.println("X oder Y");
		}
		
		//Modulo
		//System.out.println(20 % 6);
		
		//Inkrement
		a--; // a = a+1;
		a = b--;
		System.out.println(a);
		System.out.println(b);
	}
}
