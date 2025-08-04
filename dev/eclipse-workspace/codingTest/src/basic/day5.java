package basic;

import java.util.*;

public class day5 {
	public static void main (String[] args) {
		
//		int t;
//		int n;
//		int 몫 = n; 
//		for(t만큼){
//
//		몫 /= 2 나머지 = 몫 %=2
//
//		if( 몫 = 1) break }
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

				
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int result = n;
			int location = 0;
			while(result >= 1) {
				int rest = result % 2 ;
				result /= 2;		
				//System.out.println("나머지값 "+ rest);
				if ( rest == 1) {
					System.out.print(location+ " ");
				}
				//System.out.println("location count ! ");
				location++;
				}
			System.out.println();
		}

	}
}
