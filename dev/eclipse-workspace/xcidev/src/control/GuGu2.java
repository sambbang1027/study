package control;

public class GuGu2 {
	public static void main(String[] args) {
		int n = 2;		
		while(n <= 9) {
			int j = 1;
			while(j <= 9) {
				int k = 0;
				while(k<=3) {
					System.out.print((n+k) + "*" + j + "=" + (n+k)*j+"\t");		
					k++;
				}
				j++;
				System.out.println();
			}
			n+=4;
			System.out.println();
		}
	}
}

