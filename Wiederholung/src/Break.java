
public class Break {
	public void Uebung() {
		AeussereSchleife: for(int x = 0; x < 10; x++) {
			InnerSchleife: for (int y = 0; y < 10; y++) {
				if(x == 5)
					break AeussereSchleife;
				
				System.out.print("X: " + x);
				System.out.println(" Y: " + y);
				
			}
			
		}
	}
}
