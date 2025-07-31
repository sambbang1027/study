package control;

public class GuGu3 {
	public static void main(String[] args) {
		for(int i=2 ; i<=9; i+=4) {
				for(int j=1; j<=9; j++) {			
					for(int k=0; k<=3; k++) {	
						// int k=i; k<i+4; k++ 도 가능 
						System.out.print((i+k) + "*" + j +"=" + (i+k)*j+ "\t");						
				}
					System.out.println();
			}
				System.out.println();
		}
		
		System.out.println("=============================2=========================");
		
		for(int i=2; i<= 9; i++) {
			for(int j=1; j<= 9; j++) {
				for(int k=i; k<i+4; k++) {
					System.out.println((i+k) + "*" + j + "=" + (i+k) * j + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
