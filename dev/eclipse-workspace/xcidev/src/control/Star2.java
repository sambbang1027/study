package control;

public class Star2 {
	public static void main(String[] args) {
		int i=1;
		while(i<=5) {
			int j=1;
			while(j<=5) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		System.out.println("=====================");
		i=1;
		while(i<=5) {
			int j=1;
			while(j <= 5) {
				if(i <= j)System.out.print("*");
				else System.out.print(" ");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("=====================");

		i=1;
		while(i<=5) {
			int j=1;
			while(j <=5) {
				//i = 1 -> 공백 4 + 별 1
				//i = 2 -> 공백 3 + 별 2
				//i = 3 -> 공백 2 + 별 3
				//i = 4 -> 공백 1 + 별 4
				if(j >= 6-i)
					System.out.print("*");
				else 
					System.out.print(" ");
				j++;
			}
			System.out.println();
			i++;
		}
		
	}
}
